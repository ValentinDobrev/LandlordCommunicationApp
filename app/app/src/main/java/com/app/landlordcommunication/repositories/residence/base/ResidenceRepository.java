package com.app.landlordcommunication.repositories.residence.base;

import com.app.landlordcommunication.models.Residence;

import java.io.IOException;
import java.util.List;

public interface ResidenceRepository {
    List<Residence> getResidencesByUser(int userId) throws IOException;
}
