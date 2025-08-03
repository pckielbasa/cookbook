package com.pkielbasa.accountservice.application.specification;

import com.pkielbasa.accountservice.application.criteria.UserSearchCriteria;
import com.pkielbasa.accountservice.domain.model.User;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    public static Specification<User> criteria(UserSearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (criteria.username() != null && !criteria.username().isEmpty()) {
                predicate = criteriaBuilder.and(
                        predicate,
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("username")),
                                "%" + criteria.username().toLowerCase() + "%"));
            }

            if (criteria.email() != null && !criteria.email().isEmpty()) {
                predicate = criteriaBuilder.and(
                        predicate,
                        criteriaBuilder.like(root.get("email"),
                                "%" + criteria.email().toLowerCase() + "%"));
            }
            return predicate;
        };
    }
}
