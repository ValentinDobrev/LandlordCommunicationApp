package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.repositories.base.Repository;
import com.app.landlordcommunication.repositories.residence.base.ResidenceRepository;
import com.app.landlordcommunication.services.residence.HttpResidenceService;
import com.app.landlordcommunication.services.residence.base.ResidenceService;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public ResidenceService ResidenceService(ResidenceRepository repository) {
        return new HttpResidenceService(repository);
    }
}

