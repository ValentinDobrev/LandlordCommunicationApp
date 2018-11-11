package com.app.landlordcommunication.services.residence;

import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.repositories.residence.base.ResidenceRepository;
import com.app.landlordcommunication.services.residence.base.ResidenceService;

import java.io.IOException;
import java.util.List;

public class HttpResidenceService implements ResidenceService {

    private final ResidenceRepository repository;

    public HttpResidenceService(ResidenceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Residence> getResidencesByUser(int userId) throws IOException {
        return repository.getResidencesByUser(userId);
    }

    @Override
    public Residence changeResidenceDates(int residenceId) throws IOException {
        return repository.changeResidenceDates(residenceId);
    }

    @Override
    public Residence getResidenceById(int residenceId) throws IOException {
        return repository.getResidenceById(residenceId);
    }
}
