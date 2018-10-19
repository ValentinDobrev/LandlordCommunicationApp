package com.landlordcommunication.web.services;

import com.landlordcommunication.web.repositories.ResidenceRepository;
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
    public List<Residence> getResidenceByLandlord(int landlordId) {
        return repository.getResidenceByLandlord(landlordId);
    }

    @Override
    public Residence getResidenceByTenant() {
        //TODO
        return null;
    }

    @Override
    public void updateResidence() {
        //TODO
    }

    @Override
    public Residence delete() {
        //TODO
        return null;
    }

    @Override
    public Residence create() {
        //TODO
        return null;
    }

    @Override
    public List<Residence> getAllResidences() {
        return repository.getAllResidences();
    }
}
