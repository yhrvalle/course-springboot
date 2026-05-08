package com.yhr.course.services;

import com.yhr.course.entities.User;
import com.yhr.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    public User findById(Long id)
    {
        // return userRepository.findById(id).orElse(null);

        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }
}
