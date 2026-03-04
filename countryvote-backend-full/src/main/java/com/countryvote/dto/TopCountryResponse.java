package com.countryvote.dto;

public record TopCountryResponse(
        String name,
        String officialName,
        String capital,
        String region,
        String subRegion,
        Long votes
) {}
