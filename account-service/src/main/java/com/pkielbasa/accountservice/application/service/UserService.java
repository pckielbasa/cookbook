package com.pkielbasa.accountservice.application.service;

import com.pkielbasa.accountservice.application.search.criteria.UserSearchCriteria;
import com.pkielbasa.accountservice.application.search.specification.UserSpecification;
import com.pkielbasa.accountservice.application.search.sort.SortUserCriteriaUtils;
import com.pkielbasa.accountservice.application.validation.UserValidator;
import com.pkielbasa.accountservice.domain.model.User;
import com.pkielbasa.accountservice.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

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
        return userValidator.validateAndGetUserById(id);
    }

    public List<User> getUsers(UserSearchCriteria criteria) {
        Specification<User> specification = UserSpecification.criteria(criteria);
        Sort sort = SortUserCriteriaUtils.buildSort(criteria.sort(), criteria.direction());
        return userRepository.getUsers(specification, sort);
    }

    public void delete(Long id) {
        userValidator.validateAndGetUserById(id);
        userRepository.delete(id);
    }

    @Transactional
    public void changePassword(Long id, String newPassword) {
        User user = userValidator.validateAndGetUserById(id);
        updateIfNotEmpty(newPassword, user::setPassword);
        userRepository.changePassword(user);
    }

    @Transactional
    public User update(Long id, User updatedUser) {
        User user = userValidator.validateAndGetUserById(id);

        updateIfNotEmpty(updatedUser.getEmail(), user::setEmail);
        updateIfNotEmpty(updatedUser.getUsername(), user::setUsername);

        return userRepository.update(user);
    }

    private void updateIfNotEmpty(String newValue, Consumer<String> setter) {
        if (newValue != null && !newValue.isEmpty()) {
            setter.accept(newValue);
        }
    }
}
