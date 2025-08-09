package com.pkielbasa.accountservice.api.mapper;

import com.pkielbasa.accountservice.api.dto.ChangeUserRequest;
import com.pkielbasa.accountservice.api.dto.UserRequest;
import com.pkielbasa.accountservice.api.dto.UserResponse;
import com.pkielbasa.accountservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    UserResponse mapToResponse(User user);
    User mapToEntity(UserRequest userRequest);
    List<UserResponse> mapToResponse(List<User> users);
    User mapToUpdate(ChangeUserRequest newUser);
}
