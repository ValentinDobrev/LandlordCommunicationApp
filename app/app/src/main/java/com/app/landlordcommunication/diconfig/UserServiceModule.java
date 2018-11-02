package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.repositories.user.base.UserRepository;
import com.app.landlordcommunication.services.user.HttpUserService;
import com.app.landlordcommunication.services.user.base.UserService;

import dagger.Module;
import dagger.Provides;

@Module
public class UserServiceModule {
    @Provides
    public UserService UserService(UserRepository repository) {
        return new HttpUserService(repository);
    }
}
