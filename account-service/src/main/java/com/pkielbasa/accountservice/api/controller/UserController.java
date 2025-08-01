package com.pkielbasa.accountservice.api.controller;

import com.pkielbasa.accountservice.api.dto.UserRequest;
import com.pkielbasa.accountservice.api.dto.UserResponse;
import com.pkielbasa.accountservice.api.mapper.UserMapper;
import com.pkielbasa.accountservice.api.utils.UriBuilder;
import com.pkielbasa.accountservice.application.service.UserService;
import com.pkielbasa.accountservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        User newuser = userService.createUser(userMapper.mapToEntity(userRequest));
        URI location = UriBuilder.generateLocation(newuser.getId());
        return ResponseEntity.created(location).body(userMapper.mapToResponse(newuser));
    }
}
