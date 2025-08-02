package com.pkielbasa.accountservice.domain.repository;

import com.pkielbasa.accountservice.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    User createUser(User user);
    Optional<User> getUserById(Long id);
    boolean checkUsernameExist(String username);
    boolean checkEmailExist(String email);
}
