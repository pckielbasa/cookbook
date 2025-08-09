package com.pkielbasa.accountservice.domain.repository;

import com.pkielbasa.accountservice.domain.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User createUser(User user);
    Optional<User> getUserById(Long id);
    boolean checkUsernameExist(String username);
    boolean checkEmailExist(String email);
    List<User> getUsers(Specification<User> specification, Sort sort);
    void delete(Long id);
    void changePassword(User user);
}
