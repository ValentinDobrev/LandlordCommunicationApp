package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.UserDetails.RatingDialog;
import com.app.landlordcommunication.views.UserDetails.UserDetailsContracts;
import com.app.landlordcommunication.views.UserDetails.UserDetailsFragment;
import com.app.landlordcommunication.views.UserDetails.UserDetailsPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class UserDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract UserDetailsFragment usersDetailsFragment();

    @ActivityScoped
    @Binds
    abstract UserDetailsContracts.Presenter userDetailsPresenter(UserDetailsPresenter presenter);
}
