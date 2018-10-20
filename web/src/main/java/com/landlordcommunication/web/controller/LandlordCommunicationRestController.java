package com.landlordcommunication.web.controller;

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
//
//    @PutMapping("/{id}")
//    public void updateUser(@PathVariable int id, @RequestBody User user) {
//        service.update(id, user);
//    }
//

    // Residences queries
    @GetMapping("/residences/all")
    public List<Residence> getAllResidences() {
        return residenceService.getAllResidences();
    }

//    @GetMapping("/residences/{id}")
//    public List<Residence> getResidencesByLandlord(@PathVariable int id) {
//        return residenceService.getResidenceByLandlord(id);
//    }

    // User queries
    @PostMapping("/users/new")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/users/landlords")
    public List<User> getAllLandlords() {
        return userService.getAllLandlords();
    }


}
