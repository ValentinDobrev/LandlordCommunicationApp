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
        User user = userService.getUserByEmail(loginInfo);

        return new AuthorisationInfo(user.getUserId(), user.getIsTenant());

    }

}
