package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;
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
    }
