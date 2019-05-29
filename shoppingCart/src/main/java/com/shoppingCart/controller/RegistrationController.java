package com.shoppingCart.controller;

import com.shoppingCart.model.User;
import com.shoppingCart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class RegistrationController {
@Autowired
UserService userService;

@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
    User user=userService.findUserById(id);
    if (user==null){
        return new  ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }else {
      return new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
@PostMapping(value = "/create",headers = "Accept=application/json")
public ResponseEntity<Void> createUser(User user){
    userService.createUser(user);
    return new ResponseEntity<Void>(HttpStatus.CREATED);
}
    @DeleteMapping(value = "/{id}",headers = "Accept=application/json")
    public ResponseEntity<User> delete(@PathVariable("id") int id){
    User user=userService.findUserById(id);
    if(user==null){
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }
        userService.delete(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/update",headers = "Accept=application/json")
    public ResponseEntity<String> update(@RequestBody User currentUsser){
        User user=userService.findUserById(currentUsser.getUserId());
        if(user==null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        userService.update(currentUsser,currentUsser.getUserId());
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUser(){
        List<User> userList=userService.getUser();
        return userList;
    }
}
