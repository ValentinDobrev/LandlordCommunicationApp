package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.HomePage.HomePageFragment;

import dagger.Module;


import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomePageModule {


    @FragmentScoped
    @ContributesAndroidInjector
    abstract HomePageFragment homePageFragment();

}
