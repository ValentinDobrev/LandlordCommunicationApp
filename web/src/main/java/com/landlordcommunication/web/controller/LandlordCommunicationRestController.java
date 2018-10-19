package com.landlordcommunication.web.controller;

import com.landlordcommunication.web.models.Residence;
import com.landlordcommunication.web.models.User;
import com.landlordcommunication.web.services.ResidenceService;
import com.landlordcommunication.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ltr")
public class LandlordCommunicationRestController {

    private ResidenceService residenceService;
    private UserService userService;
//    private LandlordTenantService service;
//
    @Autowired
    public LandlordCommunicationRestController(ResidenceService residenceService, UserService userService) {
        this.residenceService = residenceService;
        this.userService = userService;
    }
//
//    @GetMapping("/all")
//    public List<User> getAllUsers() {
//        return service.getAll();
//    }
//
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable int id) {
//        return service.getById(id);
//    }
//
//    @PostMapping("/new")
//    public void createUser(@RequestBody User user) {
//        service.create(user);
//    }
//
//    @PutMapping("/{id}")
//    public void updateUser(@PathVariable int id, @RequestBody User user) {
//        service.update(id, user);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable int id) {
//        service.delete(id);
//    }

    // Residences queries
    @GetMapping("/residences/all")
    public List<Residence> getAllResidences() {
        return residenceService.getAllResidences();
    }

    // User queries
    @PostMapping("/users/new")
    public void createUser(User user)
    {
        userService.createUser(user);
    }

    @GetMapping("/users/landlords")
    public List<User> getAllLandlords() {
        return userService.getAllLandlords();
    }
}
