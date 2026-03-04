package com.countryvote.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record VoteRequest(
        @NotBlank String name,
        @Email String email,
        @NotBlank String countryCode
) {}
