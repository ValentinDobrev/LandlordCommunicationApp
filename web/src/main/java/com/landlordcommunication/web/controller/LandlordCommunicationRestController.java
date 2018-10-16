package com.landlordcommunication.web.controller;

import com.landlordcommunication.web.models.User;
import com.landlordcommunication.web.services.LandlordTenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ltr")
public class LandlordCommunicationRestController {

    private LandlordTenantService service;

    @Autowired
    public LandlordCommunicationRestController(LandlordTenantService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping("/new")
    public void createUser(@RequestBody User user) {
        service.create(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) {
        service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        service.delete(id);
    }
}
