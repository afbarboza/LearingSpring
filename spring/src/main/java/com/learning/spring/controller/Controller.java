package com.learning.spring.controller;

import com.learning.spring.RestPreconditions;
import com.learning.spring.model.User;
import com.learning.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("hello/spring")
public class Controller {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> fetchUserList() {
        return userService.fetchUserList();
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        RestPreconditions.checkUserNotNull(user);
        RestPreconditions.checkUserProperties(user);
        User newUser = userService.saveUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }



}
