package com.learning.spring;

import com.learning.spring.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello/spring")
public class Controller {
    @GetMapping(value = "/hello-world")
    public String getHelloWorld() {
        return "Hello World from Spring Boot";
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user) {
        System.out.println(">>>>>> Inserting new user" + user.getName());
        return user;
    }
}
