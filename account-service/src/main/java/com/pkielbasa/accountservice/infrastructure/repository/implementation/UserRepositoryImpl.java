package com.pkielbasa.accountservice.infrastructure.repository.implementation;

import com.pkielbasa.accountservice.domain.model.User;
import com.pkielbasa.accountservice.domain.repository.UserRepository;
import com.pkielbasa.accountservice.infrastructure.repository.jpa.UserRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;

    @Override
    public User createUser(User user) {
       return userRepositoryJpa.save(user);
    }
}
