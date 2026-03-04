package com.countryvote.controller;

import com.countryvote.dto.TopCountryResponse;
import com.countryvote.dto.VoteRequest;
import com.countryvote.service.VoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VoteController {

    private final VoteService service;

    public VoteController(VoteService service) {
        this.service = service;
    }

    @PostMapping("/votes")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVote(@Valid @RequestBody VoteRequest request) {
        service.createVote(request);
    }

    @GetMapping("/countries/top")
    public List<TopCountryResponse> getTopCountries() {
        return service.getTopCountries();
    }
}
