package com.maximillian.classassignment.Repository;

import com.maximillian.classassignment.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users>findByEmail(String email);
    Optional<Users>findAllByEmail();
}
