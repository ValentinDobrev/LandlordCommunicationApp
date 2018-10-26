package com.landlordcommunication.web.services;

import com.landlordcommunication.web.models.Residence;

import java.util.List;

public interface ResidenceService {
    List<Residence> getResidencesByUser(int userId);
}
