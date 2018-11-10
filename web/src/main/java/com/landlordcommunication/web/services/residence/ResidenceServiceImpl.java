package com.landlordcommunication.web.services.residence;

import com.landlordcommunication.web.repositories.residence.ResidenceRepository;
import com.landlordcommunication.web.models.Residence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidenceServiceImpl implements ResidenceService {

    private ResidenceRepository repository;

    @Autowired
    public ResidenceServiceImpl(ResidenceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Residence> getResidencesByUser(int userId) {
        return repository.getResidencesByUser(userId);
    }

    @Override
    public Residence changeResidenceDates(int residenceId) {
        return repository.changeResidenceDates(residenceId);
    }
    //TODO move getAllResidences() to this service
}
