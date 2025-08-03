package com.pkielbasa.accountservice.application.service;

import com.pkielbasa.accountservice.application.criteria.UserSearchCriteria;
import com.pkielbasa.accountservice.application.exception.UserNotFoundException;
import com.pkielbasa.accountservice.application.specification.UserSpecification;
import com.pkielbasa.accountservice.application.utils.SortUserCriteriaUtils;
import com.pkielbasa.accountservice.application.validation.UserValidator;
import com.pkielbasa.accountservice.domain.model.User;
import com.pkielbasa.accountservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> getUsers(UserSearchCriteria criteria) {
        Specification<User> specification = UserSpecification.criteria(criteria);
        Sort sort = SortUserCriteriaUtils.buildSort(criteria.sort(), criteria.direction());
        return userRepository.getUsers(specification, sort);
    }
}
