package com.securityjavatechie.springsecurityjavatechie.repository;

import com.securityjavatechie.springsecurityjavatechie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
}
