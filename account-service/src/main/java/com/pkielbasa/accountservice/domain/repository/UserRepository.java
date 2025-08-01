package com.pkielbasa.accountservice.domain.repository;

import com.pkielbasa.accountservice.domain.model.User;

public interface UserRepository {
    User createUser(User user);
}
