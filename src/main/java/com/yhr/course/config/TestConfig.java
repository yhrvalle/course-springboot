package com.yhr.course.config;

import com.yhr.course.entities.User;
import com.yhr.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired // spring padrao de DI
    private UserRepository userRepository;

    @Override // popula o database assim que roda a app
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria", "maria@gmail.com", "988888888", "12345");
        User u2 = new User(null, "John", "john@gmail.com", "977777777", "123");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
