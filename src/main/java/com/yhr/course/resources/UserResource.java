package com.yhr.course.resources;

import com.yhr.course.entities.User;
import com.yhr.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired // para isso aqui funcionar essa classe precisa estar registrada como componente spring
    // no caso @Service
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}") // users/1
    public ResponseEntity<User> findById(@PathVariable(value = "id") Long id) { // precisa estar na url
        User obj = userService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping()
    public ResponseEntity<User> insert(@RequestBody User obj) { // precisa estar no body do json
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj); // 201 created
    }

    @DeleteMapping(value =  "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build(); // 204 no content
    }

    @PutMapping(value = "/{id}") // id chega na url e o body vai ter um user obj
    public ResponseEntity<User> update(@PathVariable(value = "id") Long id, @RequestBody User obj) {
        obj = userService.update(id, obj); // atualiza no db as infos novas vindo do obj e preenche as infos que n vieram do json (password por ex)
        return ResponseEntity.ok(obj);
    }
}
