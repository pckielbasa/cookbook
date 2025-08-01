package com.pkielbasa.accountservice.api.mapper;

import com.pkielbasa.accountservice.api.dto.UserRequest;
import com.pkielbasa.accountservice.api.dto.UserResponse;
import com.pkielbasa.accountservice.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse mapToResponse(User user);
    User mapToEntity(UserRequest userRequest);
}
