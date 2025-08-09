package com.pkielbasa.accountservice.infrastructure.repository.implementation;

import com.pkielbasa.accountservice.domain.model.User;
import com.pkielbasa.accountservice.domain.repository.UserRepository;
import com.pkielbasa.accountservice.infrastructure.repository.jpa.UserRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;

    @Override
    public User createUser(User user) {
       return userRepositoryJpa.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepositoryJpa.findById(id);
    }

    @Override
    public boolean checkUsernameExist(String username) {
        return userRepositoryJpa.existsByUsername(username);
    }

    @Override
    public boolean checkEmailExist(String email) {
        return userRepositoryJpa.existsByEmail(email);
    }

    @Override
    public List<User> getUsers(Specification<User> spec, Sort sort) {
        return userRepositoryJpa.findAll(spec, sort);
    }

    @Override
    public void delete(Long id) {
        userRepositoryJpa.deleteById(id);
    }

    @Override
    public void changePassword(User user) {
        userRepositoryJpa.save(user);
    }

    @Override
    public User update(User user) {
        return userRepositoryJpa.save(user);
    }
}
