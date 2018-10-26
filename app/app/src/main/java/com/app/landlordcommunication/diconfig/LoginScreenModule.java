package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.LoginScreen.LoginScreenFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginScreenModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract LoginScreenFragment loginScreenFragment();

}
