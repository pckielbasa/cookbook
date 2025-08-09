package com.pkielbasa.accountservice.api.dto;

import jakarta.validation.constraints.NotBlank;

public record PasswordChangeRequest(
        @NotBlank String password) {}