package com.yhr.course.resources;

import com.yhr.course.entities.User;
import com.yhr.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired // para isso aqui funcionar essa classe precisa estar registrada como componente spring
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll()
    {
        List<User> list =  userService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}") // users/1 
    public ResponseEntity<User> findById(@PathVariable(value = "id") Long id)
    {
        User obj = userService.findById(id);
        return ResponseEntity.ok(obj);
    }

}
