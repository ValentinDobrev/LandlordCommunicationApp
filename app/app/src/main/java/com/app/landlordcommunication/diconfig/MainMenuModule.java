package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.MainMenu.MainMenuContracts;
import com.app.landlordcommunication.views.MainMenu.MainMenuFragment;
import com.app.landlordcommunication.views.MainMenu.MainMenuPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainMenuModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MainMenuFragment mainMenuFragment();

    @ActivityScoped
    @Binds
    abstract MainMenuContracts.Presenter mainMenuPresenter(MainMenuPresenter presenter);

}
