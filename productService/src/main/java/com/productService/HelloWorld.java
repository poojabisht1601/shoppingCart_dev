package com.productService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorld {
    @RequestMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Boot Tutorials";
    }
    @RequestMapping("/hello")
    public String myData() {
        return "Hello Spring Boot";
    }
}
