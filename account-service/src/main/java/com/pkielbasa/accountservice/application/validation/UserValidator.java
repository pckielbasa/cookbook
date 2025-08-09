package com.pkielbasa.accountservice.application.validation;

import com.pkielbasa.accountservice.application.exception.UserAlreadyExistsException;
import com.pkielbasa.accountservice.application.exception.UserNotFoundException;
import com.pkielbasa.accountservice.domain.model.User;
import com.pkielbasa.accountservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserValidator {

    private final UserRepository userRepository;

    public void validateUserDontExist(String username, String email) {
        validateUsername(username);
        validateEmailExist(email);
    }

    public User validateAndGetUserById(Long id) {
        return userRepository.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " +id));
    }

    private void validateUsername(String username) {
        if (userRepository.checkUsernameExist(username)) {
            throw new UserAlreadyExistsException("User already exists with username: " + username);
        }
    }

    private void validateEmailExist(String email) {
        if (userRepository.checkEmailExist(email)) {
            throw new UserAlreadyExistsException("User already exists with email: " + email);
        }
    }
}
