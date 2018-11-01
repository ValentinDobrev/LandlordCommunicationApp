package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.http.HttpRequester;
import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.parsers.base.JsonParser;
import com.app.landlordcommunication.repositories.user.HttpUserRepository;
import com.app.landlordcommunication.repositories.user.base.UserRepository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UsersRepositoryModule {
    @Provides
    @Singleton
    public UserRepository userRepository(@Named("baseServerUrl") String baseServerUrl, HttpRequester httpRequester, @Named("userParser") JsonParser<User> userJsonParser, @Named("ratingParser") JsonParser<Rating> ratingJSonParser) {
        return new HttpUserRepository(httpRequester, baseServerUrl, userJsonParser, ratingJSonParser);
    }
}
