package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.ChatScreen.ChatScreenContracts;
import com.app.landlordcommunication.views.ChatScreen.ChatScreenPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ChatScreenPresenterModule {
    @Provides
    ChatScreenContracts.Presenter ChatScreenPresenter(ChatScreenPresenter presenter){
        return presenter;
    }
}
