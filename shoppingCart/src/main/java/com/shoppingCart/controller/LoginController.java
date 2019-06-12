package com.shoppingCart.controller;

import com.shoppingCart.model.Login;
import com.shoppingCart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {
    @Autowired
    public UserService userService;
    @PostMapping(value = "/login",headers = "Accept=application/json")
    public ResponseEntity<Void> login(@RequestBody Login login ){
    if(userService.validateUser(login)){
     return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
