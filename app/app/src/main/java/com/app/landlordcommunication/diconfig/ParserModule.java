package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.parsers.GsonJsonParser;
import com.app.landlordcommunication.parsers.base.JsonParser;

import dagger.Module;
import dagger.Provides;

@Module
    public class ParserModule {
        @Provides
        public JsonParser<Residence> residenceJsonParser() {
            return new GsonJsonParser<>(Residence.class, Residence[].class);
        }
    }
