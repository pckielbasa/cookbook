package com.pkielbasa.accountservice.application.service;

import com.pkielbasa.accountservice.application.exception.UserNotFoundException;
import com.pkielbasa.accountservice.application.validation.UserValidator;
import com.pkielbasa.accountservice.domain.model.User;
import com.pkielbasa.accountservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public User createUser(User user) {
        userValidator.validateUserDontExist(user.getUsername(), user.getEmail());
        return userRepository.createUser(user);
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " +id));
    }
}
