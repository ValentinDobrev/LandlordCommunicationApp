package com.landlordcommunication.web.services;

import com.landlordcommunication.web.models.Residence;

import java.util.List;

public interface ResidenceService {
    List<Residence> getResidenceByUser(int userId);

    Residence getResidenceByTenant();

    void updateResidence();

    Residence delete();

    Residence create();

    List<Residence> getAllResidences();

    List<Residence> getResidencesByUser(int userId);
}
