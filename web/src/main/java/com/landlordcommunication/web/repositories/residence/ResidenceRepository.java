package com.landlordcommunication.web.repositories.residence;

import com.landlordcommunication.web.models.Residence;

import java.util.List;

public interface ResidenceRepository {

    List<Residence> getResidencesByUser(int userId);
}
