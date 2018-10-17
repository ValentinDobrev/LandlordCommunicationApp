package com.landlordcommunication.web.repositories;

import com.landlordcommunication.web.models.Residence;

import java.util.ArrayList;
import java.util.List;

public class SqlResidenceRepository implements ResidenceRepository {


    @Override
    public Residence getResidenceByLandlord(int landlordId) {
        return null;
    }

    @Override
    public Residence getResidenceByTenant() {
        return null;
    }

    @Override
    public void updateResidence() {

    }

    @Override
    public Residence delete() {
        return null;
    }

    @Override
    public Residence create() {
        return null;
    }

    @Override
    public List<Residence> getAllResidences() {
       List<Residence> result = new ArrayList<>();






       return result;
    }
}
