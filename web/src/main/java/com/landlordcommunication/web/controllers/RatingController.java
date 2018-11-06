package com.landlordcommunication.web.controllers;

import com.landlordcommunication.web.models.UserRating;
import com.landlordcommunication.web.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

    private UserService service;

    @Autowired
    public RatingController(UserService service) {
        setService(service);
    }

    @GetMapping("/{id}")
    public UserRating getRatingById(@PathVariable int id) {
        return service.getRatingById(id);
    }

    private void setService(UserService service) {
        this.service = service;
    }
}
