package com.securityjavatechie.springsecurityjavatechie;

import com.securityjavatechie.springsecurityjavatechie.entity.User;
import com.securityjavatechie.springsecurityjavatechie.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@AllArgsConstructor
public class SpringSecurityJavatechieApplication {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJavatechieApplication.class, args);
    }

    @Bean
    public void initUsers(){
        List<User> users = Stream.of(
                new User(101, "user1", passwordEncoder.encode("password"), "user1@security.com"),
                new User(102, "user2", passwordEncoder.encode("password"), "user2@security.com"),
                new User(103, "user3", passwordEncoder.encode("password"), "user3@security.com"),
                new User(104, "user4", passwordEncoder.encode("password"), "user4@security.com")
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }
}
