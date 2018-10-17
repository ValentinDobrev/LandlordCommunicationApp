package com.landlordcommunication.web.repositories;

import com.landlordcommunication.web.models.Residence;

import java.util.List;

public interface ResidenceRepository {

    Residence getResidenceByLandlord(int landlordId);

    Residence getResidenceByTenant();

    void updateResidence();

    Residence delete();

    Residence create();

    List<Residence> getAllResidences();

}
