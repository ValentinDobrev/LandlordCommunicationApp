package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.async.AsyncSchedulerProvider;
import com.app.landlordcommunication.async.base.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AsyncModule {
    @Provides
    @Singleton
    public SchedulerProvider schedulerProvider() {
        return AsyncSchedulerProvider.getInstance();
    }
}
