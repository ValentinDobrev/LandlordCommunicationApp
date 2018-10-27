package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.HomePage.HomePageActivity;
import com.app.landlordcommunication.views.LoginScreen.LoginScreenActivity;
import com.app.landlordcommunication.views.ResidenceOverview.ResidenceOverviewActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


    @Module
    public abstract class ActivityBindingModule {

        //non-base
        @ActivityScoped
        @ContributesAndroidInjector(modules = LoginScreenModule.class)
        abstract LoginScreenActivity loginScreenActivity();


        //base
        @ActivityScoped
        @ContributesAndroidInjector(modules = HomePageModule.class)
        abstract HomePageActivity homePageActivity();

        @ActivityScoped
        @ContributesAndroidInjector(modules = ResidenceOverviewModule.class)
        abstract ResidenceOverviewActivity residenceOverviewActivity();

}
