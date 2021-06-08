package ru.coffee.nostresso.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class TokenResponse {
    private final String jwt;
}
