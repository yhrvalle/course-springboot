package com.yhr.course.services;

import com.yhr.course.entities.User;
import com.yhr.course.repositories.UserRepository;
import com.yhr.course.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj)
    {
        return userRepository.save(obj);
    }

    public void delete(Long id)
    {
        userRepository.deleteById(id);
    }

    @Transactional
    public User update(Long id, User obj)
    {
        User entity = userRepository.getReferenceById(id); // prepara o objeto para trabalahr nele
        updateData(entity, obj);
        return userRepository.save(entity);

    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
