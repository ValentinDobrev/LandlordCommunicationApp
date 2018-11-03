package com.landlordcommunication.web.controllers;

import com.landlordcommunication.web.models.AuthorisationInfo;
import com.landlordcommunication.web.models.LoginInfo;
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
    public AuthorisationInfo getUserByEmail(@RequestBody LoginInfo loginInfo){
        //the user object in this method will contain a surname with an error text if there is not such user in the DB
        return userService.getUserByEmail(loginInfo);
    }

}
