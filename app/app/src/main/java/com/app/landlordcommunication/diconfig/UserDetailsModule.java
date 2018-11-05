package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.user_details.UserDetailsContracts;
import com.app.landlordcommunication.views.user_details.UserDetailsFragment;
import com.app.landlordcommunication.views.user_details.UserDetailsPresenter;

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
