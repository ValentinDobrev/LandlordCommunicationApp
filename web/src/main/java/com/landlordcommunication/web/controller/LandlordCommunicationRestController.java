package com.landlordcommunication.web.controller;

import com.landlordcommunication.web.models.Rating;
import com.landlordcommunication.web.models.Residence;
import com.landlordcommunication.web.models.User;
import com.landlordcommunication.web.services.ResidenceService;
import com.landlordcommunication.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LandlordCommunicationRestController {

    private ResidenceService residenceService;
    private UserService userService;

    @Autowired
    public LandlordCommunicationRestController(ResidenceService residenceService, UserService userService) {
        this.residenceService = residenceService;
        this.userService = userService;
    }

    // Residences queries
    @GetMapping("/residences/all")
    public List<Residence> getAllResidences() {
        return residenceService.getAllResidences();
    }

    @GetMapping("/residences-for-user/{id}")
    public List<Residence> getResidencesByUser(@PathVariable int id) {
        return residenceService.getResidencesByUser(id);
    }

    // User queries
    @PostMapping("/users/new")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public void modifyUser(@PathVariable int id, @RequestBody User user) {
        userService.modifyUser(id, user);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/users/landlords")
    public List<User> getAllLandlords() {
        return userService.getAllLandlords();
    }

    @GetMapping("/users/rating/{id}")
    public List<Rating> getUserRating(@PathVariable int id){
        return userService.getUserRating(id);
    }

    @GetMapping("/users-in-residence/{id}")
    public List<User> getUsersByResidence(@PathVariable int id) {
        return userService.getUsersByResidence(id);
    }

}
