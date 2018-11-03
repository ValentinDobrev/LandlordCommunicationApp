package com.app.landlordcommunication.diconfig;


import com.app.landlordcommunication.views.LoginScreen.LoginScreenContracts;
import com.app.landlordcommunication.views.LoginScreen.RealLoginScreenFragment;
import com.app.landlordcommunication.views.LoginScreen.RealLoginScreenPresenter;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RealLoginScreenModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract RealLoginScreenFragment realLoginScreenFragment();

    /*@ActivityScoped
    @Binds
    abstract LoginScreenContracts.Presenter loginScreenPresenter(RealLoginScreenPresenter presenter);*/

}