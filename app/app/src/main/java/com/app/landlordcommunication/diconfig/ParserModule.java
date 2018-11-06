package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.models.Message;
import com.app.landlordcommunication.models.AuthorisationInfo;
import com.app.landlordcommunication.models.LoginInfo;
import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.models.UserRating;
import com.app.landlordcommunication.parsers.GsonJsonParser;
import com.app.landlordcommunication.parsers.base.JsonParser;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
    public class ParserModule {
        @Provides
        @Named("ResidenceParser")
        public JsonParser<Residence> residenceJsonParser() {
            return new GsonJsonParser<>(Residence.class, Residence[].class);
        }
        @Provides
        @Named("UserParser")
        public JsonParser<User> userJsonParser() {
            return new GsonJsonParser<>(User.class, User[].class);
        }
        @Provides
        @Named("RatingParser")
        public JsonParser<Rating> ratingJsonParser() {
            return new GsonJsonParser<>(Rating.class, Rating[].class);
        }
        @Provides
        @Named("MessageParser")
        public JsonParser<Message> messageJsonParser() {
            return new GsonJsonParser<>(Message.class, Message[].class);
        }
        @Provides
        @Named("LoginInfoParser")
        public JsonParser<LoginInfo> loginInfoJsonParser() {
            return new GsonJsonParser<>(LoginInfo.class, LoginInfo[].class);
        }

        @Provides
        @Named("AuthorisationInfoJsonParser")
        public JsonParser<AuthorisationInfo> authorisationInfoJsonParser() {
            return new GsonJsonParser<>(AuthorisationInfo.class, AuthorisationInfo[].class);
        }

        @Provides
        @Named("ratingParser")
        public JsonParser<UserRating> userRatingJsonParser() {
            return new GsonJsonParser<>(UserRating.class, UserRating[].class);
        }
    }
