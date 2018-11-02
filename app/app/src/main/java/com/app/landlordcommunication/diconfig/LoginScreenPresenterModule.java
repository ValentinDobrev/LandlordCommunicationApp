package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.LoginScreen.LoginScreenContracts;
import com.app.landlordcommunication.views.LoginScreen.RealLoginScreenPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginScreenPresenterModule {
    @Provides
    LoginScreenContracts.Presenter loginScreenPresenter(RealLoginScreenPresenter presenter){

        return presenter;

    }
}
