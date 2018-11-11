package com.landlordcommunication.web.services.residence;

import com.landlordcommunication.web.models.Residence;

import java.util.List;

public interface ResidenceService {
    List<Residence> getResidencesByUser(int userId);

    Residence changeResidenceDates(int residenceId);
    Residence getResidenceById(int residenceId);
}
