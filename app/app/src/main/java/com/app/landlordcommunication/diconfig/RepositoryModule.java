package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.http.HttpRequester;
import com.app.landlordcommunication.models.AuthorisationInfo;
import com.app.landlordcommunication.models.LoginInfo;
import com.app.landlordcommunication.models.Message;
import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.models.UserRating;
import com.app.landlordcommunication.parsers.base.JsonParser;
import com.app.landlordcommunication.repositories.message.HttpMessageRepository;
import com.app.landlordcommunication.repositories.message.base.MessageRepository;
import com.app.landlordcommunication.repositories.rating.HttpRatingRepository;
import com.app.landlordcommunication.repositories.rating.base.RatingRepository;
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
    @Singleton
    public UserRepository userRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            @Named("UserParser")JsonParser<User> jsonParserUser,
            @Named("RatingParser")JsonParser<Rating> jsonParserRating,
            @Named("LoginInfoParser")JsonParser<LoginInfo> loginInfoJsonParser,
            @Named("AuthorisationInfoJsonParser")JsonParser<AuthorisationInfo> authorisationInfoJsonParser
    ) {
        String url = baseServerUrl + "/users";
        return new HttpUserRepository(httpRequester, url, jsonParserUser, jsonParserRating, authorisationInfoJsonParser, loginInfoJsonParser);
    }

    @Provides
    @Singleton
    public MessageRepository messageRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            @Named("MessageParser") JsonParser<Message> jsonParserMessage
    ) {
        String url = baseServerUrl + "/messages/for-receiver-by-sender";
        return new HttpMessageRepository(httpRequester, url, jsonParserMessage);
    }

    @Provides
    @Singleton
    public RatingRepository ratingRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            @Named("ratingParser") JsonParser<UserRating> ratingJsonParser
    ) {
        String url = baseServerUrl + "/rating";
        return new HttpRatingRepository(httpRequester, url, ratingJsonParser);
    }
}
