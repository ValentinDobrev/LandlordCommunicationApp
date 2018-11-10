package com.app.landlordcommunication.services.residence.base;

import com.app.landlordcommunication.models.Residence;

import java.io.IOException;
import java.util.List;

public interface ResidenceService {
    List<Residence> getResidencesByUser(int userId) throws IOException;

    Residence changeResidenceDates(int residenceId) throws IOException;
}
