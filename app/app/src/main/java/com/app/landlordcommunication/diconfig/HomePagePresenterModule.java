package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.HomePage.HomePageContracts;
import com.app.landlordcommunication.views.HomePage.HomePagePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class HomePagePresenterModule {
    @Provides
    HomePageContracts.Presenter homePagePresenter(HomePagePresenter presenter){

        return presenter;

    }


}
