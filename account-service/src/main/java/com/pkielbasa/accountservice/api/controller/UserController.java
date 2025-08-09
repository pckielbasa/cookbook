package com.pkielbasa.accountservice.api.controller;

import com.pkielbasa.accountservice.api.dto.ChangeUserRequest;
import com.pkielbasa.accountservice.api.dto.PasswordChangeRequest;
import com.pkielbasa.accountservice.api.dto.UserRequest;
import com.pkielbasa.accountservice.api.dto.UserResponse;
import com.pkielbasa.accountservice.api.mapper.UserMapper;
import com.pkielbasa.accountservice.api.utils.UriBuilder;
import com.pkielbasa.accountservice.application.search.criteria.UserSearchCriteria;
import com.pkielbasa.accountservice.application.service.UserService;
import com.pkielbasa.accountservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        User newUser = userService.createUser(userMapper.mapToEntity(request));
        URI location = UriBuilder.generateLocation(newUser.getId());
        return ResponseEntity.created(location).body(userMapper.mapToResponse(newUser));
    }

    @GetMapping("/{id}")
    ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userMapper.mapToResponse(userService.getUserById(id)));
    }

    @GetMapping
    ResponseEntity<List<UserResponse>> getUsers(@ModelAttribute UserSearchCriteria criteria) {
        return ResponseEntity.ok(userMapper.mapToResponse(userService.getUsers(criteria)));
    }

    @PatchMapping("/{id}")
    ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody ChangeUserRequest request) {
        User updatedUser = userService.update(id, userMapper.mapToUpdate(request));
        return ResponseEntity.ok(userMapper.mapToResponse(updatedUser));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/password")
    ResponseEntity<?> updatePassword(@PathVariable Long id, @RequestBody PasswordChangeRequest request) {
        userService.changePassword(id, request.password());
        return ResponseEntity.noContent().build();
    }

}
