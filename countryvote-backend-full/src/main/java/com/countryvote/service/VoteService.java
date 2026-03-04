package com.countryvote.service;

import com.countryvote.dto.TopCountryResponse;
import com.countryvote.dto.VoteRequest;
import com.countryvote.entity.Vote;
import com.countryvote.exception.EmailAlreadyVotedException;
import com.countryvote.repository.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VoteService {

    private final VoteRepository repository;
    private final WebClient webClient;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
        this.webClient = WebClient.create("https://restcountries.com/v3.1");
    }

    public void createVote(VoteRequest request) {

        if (repository.existsByEmail(request.email())) {
            throw new EmailAlreadyVotedException();
        }

        Vote vote = new Vote();
        vote.setName(request.name());
        vote.setEmail(request.email());
        vote.setCountryCode(request.countryCode());
        vote.setCreatedAt(LocalDateTime.now());

        repository.save(vote);
    }

    public List<TopCountryResponse> getTopCountries() {

        List<Object[]> results = repository.findTopCountries();
        List<TopCountryResponse> response = new ArrayList<>();

        for (Object[] row : results.stream().limit(10).toList()) {

            String code = (String) row[0];
            Long votes = (Long) row[1];

            var country = webClient.get()
                    .uri("/alpha/{code}", code)
                    .retrieve()
                    .bodyToMono(Object[].class)
                    .block();

            if (country != null && country.length > 0) {
                var data = (java.util.Map<?, ?>) country[0];

                String name = ((java.util.Map<?, ?>) data.get("name")).get("common").toString();
                String official = ((java.util.Map<?, ?>) data.get("name")).get("official").toString();
                String capital = data.get("capital") != null ? ((java.util.List<?>) data.get("capital")).get(0).toString() : "";
                String region = data.get("region").toString();
                String subregion = data.get("subregion") != null ? data.get("subregion").toString() : "";

                response.add(new TopCountryResponse(name, official, capital, region, subregion, votes));
            }
        }

        return response;
    }
}
