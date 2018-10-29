package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.DrawerFragment;
import com.app.landlordcommunication.views.LoginScreen.LoginScreenFragment;
import com.app.landlordcommunication.views.ResidenceOverview.ResidenceOverviewFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ResidenceOverviewModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ResidenceOverviewFragment residenceOverviewFragment();

}
