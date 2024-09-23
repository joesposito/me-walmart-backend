package com.walmart.api.Walmart.API.controller;

import com.walmart.api.Walmart.API.entity.User;
import com.walmart.api.Walmart.API.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }
}
