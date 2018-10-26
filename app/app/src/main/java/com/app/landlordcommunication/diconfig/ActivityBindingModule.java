package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.HomePage.HomePageActivity;
import com.app.landlordcommunication.views.LoginScreen.LoginScreenActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


    @Module
    public abstract class ActivityBindingModule {
        @ActivityScoped
        @ContributesAndroidInjector()
        abstract HomePageActivity homePageActivity();

        @ActivityScoped
        @ContributesAndroidInjector()
        abstract LoginScreenActivity loginScreenActivity();

}
