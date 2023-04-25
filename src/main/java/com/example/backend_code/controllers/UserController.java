package com.example.backend_code.controllers;


import com.example.backend_code.models.User;
import com.example.backend_code.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    // INDEX
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping (value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping (value = "/{name}")
    public ResponseEntity<User> getUserById(@PathVariable String name) {
        return new ResponseEntity<>(userService.findByUserByName(name), HttpStatus.OK);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        userService.updateUser(user, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
