package com.landlordcommunication.web.services;

import com.landlordcommunication.web.repositories.ResidenceRepository;
import com.landlordcommunication.web.models.Residence;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResidenceServiceImpl implements ResidenceService {

    private ResidenceRepository repository;

    @Autowired
    public ResidenceServiceImpl(ResidenceRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Residence getResidenceByLandlord() {
        //TODO
        return null;
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
        //TODO
        return null;
    }
}
