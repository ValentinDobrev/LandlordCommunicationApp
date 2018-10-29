package com.landlordcommunication.web.controller;

import com.landlordcommunication.web.models.Residence;
import com.landlordcommunication.web.services.residence.ResidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/residences")
public class ResidenceRestController {

    private ResidenceService residenceService;

    @Autowired
    public ResidenceRestController(ResidenceService residenceService) {
        this.residenceService = residenceService;
    }

    @GetMapping("/{id}")
    public List<Residence> getResidencesByUser(@PathVariable int id) {
        return residenceService.getResidencesByUser(id);
    }
}
