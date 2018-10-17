package com.landlordcommunication.web;

import com.landlordcommunication.web.models.Residence;

import java.util.List;

public interface ResidenceRepository {

    Residence getResidenceByLandlord();

    Residence getResidenceByTenant();

    void updateResidence();

    Residence delete();

    Residence create();

    List<Residence> getAllResidences();

}
