package com.landlordcommunication.web.controllers;

import com.landlordcommunication.web.models.User;
import com.landlordcommunication.web.services.user.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User getUserByEmail(@RequestBody String email){
        return userService.getUserByEmail(email);
    }

}
