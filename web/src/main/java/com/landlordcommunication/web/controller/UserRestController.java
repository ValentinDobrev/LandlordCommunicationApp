package com.landlordcommunication.web.controller;

import com.landlordcommunication.web.models.Rating;
import com.landlordcommunication.web.models.User;
import com.landlordcommunication.web.services.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/{id}")
    public void modifyUser(@PathVariable int id, @RequestBody User user) {
        userService.modifyUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/landlords")
    public List<User> getAllLandlords() {
        return userService.getAllLandlords();
    }

    @GetMapping("/rating/{id}")
    public List<Rating> getUserRating(@PathVariable int id) {
        return userService.getUserRating(id);
    }

    @GetMapping("/in-residence/{id}")
    public List<User> getUsersByResidence(@PathVariable int id) {
        return userService.getUsersByResidence(id);
    }

    @PutMapping("pay-rent/{tenantId}/{landlordId}/{residenceId}")
    public void payRentFromTenantToLandlord(@PathVariable int tenantId, @PathVariable int landlordId, @PathVariable int residenceId) {
        userService.payRentFromTenantToLandlord(tenantId, landlordId, residenceId);
    }
}
