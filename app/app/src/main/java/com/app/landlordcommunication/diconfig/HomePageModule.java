package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.HomePage.HomePageContracts;
import com.app.landlordcommunication.views.HomePage.HomePageFragment;
import com.app.landlordcommunication.views.HomePage.HomePagePresenter;

import dagger.Binds;
import dagger.Module;


import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomePageModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract HomePageFragment homePageFragment();

    @ActivityScoped
    @Binds
    abstract HomePageContracts.Presenter homePagePresenter(HomePagePresenter presenter);

}
