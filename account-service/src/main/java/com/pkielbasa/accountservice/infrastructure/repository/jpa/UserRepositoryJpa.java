package com.pkielbasa.accountservice.infrastructure.repository.jpa;

import com.pkielbasa.accountservice.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<User, Long> {
}
