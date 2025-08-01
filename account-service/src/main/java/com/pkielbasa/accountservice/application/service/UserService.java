package com.pkielbasa.accountservice.application.service;

import com.pkielbasa.accountservice.domain.model.User;
import com.pkielbasa.accountservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.createUser(user);
    }
}
