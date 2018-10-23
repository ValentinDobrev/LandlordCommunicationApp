package com.app.landlordcommunication.diconfig;


import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.http.HttpRequester;
import com.app.landlordcommunication.http.OkHttpHttpRequester;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {
    @Provides
    public HttpRequester httpRequester() {
        return new OkHttpHttpRequester();
    }

    @Provides
    @Named("baseServerUrl")
    public String baseServerUrl() {
        return Constants.BASE_SERVER_URL;
    }
}
