package com.pkielbasa.accountservice.application.criteria;

import jakarta.validation.constraints.Email;

public record UserSearchCriteria(
        String username,
        @Email String email,
        String sort,
        String direction
) {}
