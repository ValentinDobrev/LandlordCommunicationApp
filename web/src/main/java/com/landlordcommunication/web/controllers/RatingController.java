package com.landlordcommunication.web.controllers;

import com.landlordcommunication.web.models.Rating;
import com.landlordcommunication.web.models.UserRating;
import com.landlordcommunication.web.services.rating.RatingService;
import com.landlordcommunication.web.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

    private UserService service;
    private RatingService ratingService;

    @Autowired
    public RatingController(UserService service, RatingService ratingService) {
        setService(service);
        setRatingService(ratingService);
    }

    @GetMapping("/{id}")
    public UserRating getRatingById(@PathVariable int id) {
        return service.getRatingById(id);
    }

    @PostMapping
    public Rating addNewRatingRecord(@RequestBody Rating ratingRecord) {
        return ratingService.addRatingRecord(ratingRecord);
    }

    private void setService(UserService service) {
        this.service = service;
    }

    private void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }
}
