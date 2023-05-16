package com.learning.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello/spring")
public class Controller {
    @GetMapping(value = "/hello-world")
    public String getHelloWorld() {
        return "Hello World from Spring Boot";
    }
}
