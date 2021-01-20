package com.geeksHub.dev.controllers;

import com.geeksHub.dev.dtos.UserDto;
import com.geeksHub.dev.entities.User;
import com.geeksHub.dev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        User user = this.userService.save(userDto);
        return user;
    }
}
