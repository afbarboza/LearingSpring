package com.learning.spring;

import com.learning.spring.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("hello/spring")
public class Controller {
    @GetMapping(value = "/hello-world")
    public String getHelloWorld() {
        return "Hello World from Spring Boot";
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        RestPreconditions.checkUserNotNull(user);
        RestPreconditions.checkUserProperties(user);
        User newUser = mockNewUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }

    private User mockNewUser(User user) {
        User user1 = new User();
        user1.setId(1);
        user1.setName(user.getName());
        user1.setPassword("admin");
        user1.setRoles("ADMIN");
        return user1;
    }

}
