package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.HomePage.HomePageActivity;
import com.app.landlordcommunication.views.LoginScreen.LoginScreenActivity;
import com.app.landlordcommunication.views.LoginScreen.RealLoginScreenActivity;
import com.app.landlordcommunication.views.ResidenceOverview.ResidenceOverviewActivity;
import com.app.landlordcommunication.views.user_details.UserDetailsActivity;
import com.app.landlordcommunication.views.users_list.UsersListActivity;

import dagger.Component;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


    @Module
    public abstract class ActivityBindingModule {

        //non-base
        @ActivityScoped
        @ContributesAndroidInjector(modules = LoginScreenModule.class)
        abstract LoginScreenActivity loginScreenActivity();

        @ActivityScoped
        @ContributesAndroidInjector(modules = RealLoginScreenModule.class)
        abstract RealLoginScreenActivity realLoginScreenActivity();


        //base
        @ActivityScoped
        @ContributesAndroidInjector(modules = HomePageModule.class)
        abstract HomePageActivity homePageActivity();

        @ActivityScoped
        @ContributesAndroidInjector(modules = ResidenceOverviewModule.class)
        abstract ResidenceOverviewActivity residenceOverviewActivity();

        @ActivityScoped
        @ContributesAndroidInjector(modules = UsersListModule.class)
        abstract UsersListActivity usersListActivity();

        @ActivityScoped
        @ContributesAndroidInjector(modules = UserDetailsModule.class)
        abstract UserDetailsActivity userDetailsActivity();

}
