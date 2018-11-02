package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.http.HttpRequester;
import com.app.landlordcommunication.models.Message;
import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.parsers.base.JsonParser;
import com.app.landlordcommunication.repositories.residence.HttpResidenceRepository;
import com.app.landlordcommunication.repositories.residence.base.ResidenceRepository;
import com.app.landlordcommunication.repositories.user.HttpUserRepository;
import com.app.landlordcommunication.repositories.user.base.UserRepository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
//    @Named("baseServerUrlResidence")
    @Singleton
    public ResidenceRepository residenceRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            @Named("ResidenceParser") JsonParser<Residence> jsonParser
    ) {
        String url = baseServerUrl + "/residences";
        return new HttpResidenceRepository(httpRequester, url, jsonParser);
    }

    @Provides
//    @Named("baseServerUrlUser")
    @Singleton
    public UserRepository userRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            @Named("UserParser") JsonParser<User> jsonParserUser,
            @Named("RatingParser")JsonParser<Rating> jsonParserRating
    ) {
        String url = baseServerUrl + "/users";
        return new HttpUserRepository(httpRequester, url, jsonParserUser, jsonParserRating);
    }

}
