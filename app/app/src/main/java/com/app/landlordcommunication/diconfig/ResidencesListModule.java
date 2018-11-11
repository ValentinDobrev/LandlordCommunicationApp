package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.ResidencesList.ResidencesListContracts;
import com.app.landlordcommunication.views.ResidencesList.ResidencesListFragment;
import com.app.landlordcommunication.views.ResidencesList.ResidencesListPresenter;

import dagger.Binds;
import dagger.Module;


import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ResidencesListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract ResidencesListFragment residencesListFragment();

    @ActivityScoped
    @Binds
    abstract ResidencesListContracts.Presenter residencesListPresenter(ResidencesListPresenter presenter);

}
