package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.http.HttpRequester;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.parsers.base.JsonParser;
import com.app.landlordcommunication.repositories.residence.HttpResidenceRepository;
import com.app.landlordcommunication.repositories.residence.base.ResidenceRepository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public ResidenceRepository residenceRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            @Named("residenceParser") JsonParser<Residence> jsonParser
    ) {
        String url = baseServerUrl;
        return new HttpResidenceRepository(httpRequester, url, jsonParser);
    }




}
