package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.models.Message;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.repositories.base.Repository;
import com.app.landlordcommunication.repositories.message.base.MessageRepository;
import com.app.landlordcommunication.repositories.residence.base.ResidenceRepository;
import com.app.landlordcommunication.repositories.user.base.UserRepository;
import com.app.landlordcommunication.services.message.HttpMessageService;
import com.app.landlordcommunication.services.message.base.MessageService;
import com.app.landlordcommunication.services.residence.HttpResidenceService;
import com.app.landlordcommunication.services.residence.base.ResidenceService;
import com.app.landlordcommunication.services.user.HttpUserService;
import com.app.landlordcommunication.services.user.base.UserService;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public ResidenceService ResidenceService(ResidenceRepository repository) {
        return new HttpResidenceService(repository);
    }
    @Provides
    public UserService UserService(UserRepository repository) {
        return new HttpUserService(repository);
    }
    @Provides
    public MessageService MessageService(MessageRepository repository) {
        return new HttpMessageService(repository);
    }
}

