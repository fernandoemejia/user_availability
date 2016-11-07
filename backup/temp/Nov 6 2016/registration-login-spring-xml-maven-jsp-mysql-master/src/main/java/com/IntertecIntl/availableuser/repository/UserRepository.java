package com.IntertecIntl.availableuser.repository;

import com.IntertecIntl.availableuser.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
