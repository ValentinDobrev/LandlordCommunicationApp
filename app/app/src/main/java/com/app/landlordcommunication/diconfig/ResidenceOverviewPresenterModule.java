package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.ResidenceOverview.ResidenceOverviewContracts;
import com.app.landlordcommunication.views.ResidenceOverview.ResidenceOverviewPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ResidenceOverviewPresenterModule {
        @Provides
        ResidenceOverviewContracts.Presenter homePagePresenter(ResidenceOverviewPresenter presenter){
            return presenter;

        }
}
