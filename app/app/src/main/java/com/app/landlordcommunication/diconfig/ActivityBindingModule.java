package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.HomePage.HomePageActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


    @Module
    public abstract class ActivityBindingModule {
        @ActivityScoped
        @ContributesAndroidInjector(/*modules = TasksModule.class*/)
        abstract HomePageActivity homePageActivity();

}
