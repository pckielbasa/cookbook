package com.pkielbasa.accountservice.infrastructure.repository.jpa;

import com.pkielbasa.accountservice.domain.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    boolean existsByEmail(@Email String email);
    boolean existsByUsername(@NotBlank String username);
}
