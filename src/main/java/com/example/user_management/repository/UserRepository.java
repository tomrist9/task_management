package com.example.user_management.repository;

import com.example.user_management.registration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmailAndIsDeletedFalse(String email);
    Optional<User> findByEmailAndIsDeletedFalse(String email);
    Optional<User> findByUsernameAndIsDeletedFalse(String username);

}
