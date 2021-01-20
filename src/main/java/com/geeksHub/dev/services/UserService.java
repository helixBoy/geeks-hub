package com.geeksHub.dev.services;

import com.geeksHub.dev.dtos.UserDto;
import com.geeksHub.dev.entities.User;
import com.geeksHub.dev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(UserDto userDto) {
        User user = new User();
        user.firstName = userDto.first_name;
        user.lastName = userDto.last_name;
        user.username = userDto.username;
        user.password = userDto.password;
        user.roles = "ROLE_USER";
        return userRepository.save(user);
    }
 }
