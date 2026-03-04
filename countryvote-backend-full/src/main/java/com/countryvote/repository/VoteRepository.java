package com.countryvote.repository;

import com.countryvote.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface VoteRepository extends JpaRepository<Vote, UUID> {

    boolean existsByEmail(String email);

    @Query("""
        SELECT v.countryCode, COUNT(v)
        FROM Vote v
        GROUP BY v.countryCode
        ORDER BY COUNT(v) DESC
        """)
    List<Object[]> findTopCountries();
}
