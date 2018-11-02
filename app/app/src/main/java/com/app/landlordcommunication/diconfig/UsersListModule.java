package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.users_list.UsersListContracts;
import com.app.landlordcommunication.views.users_list.UsersListFragment;
import com.app.landlordcommunication.views.users_list.UsersListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class UsersListModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract UsersListFragment usersListFragment();

    @ActivityScoped
    @Binds
    abstract UsersListContracts.Presenter usersListPresenter(UsersListPresenter presenter);
}
