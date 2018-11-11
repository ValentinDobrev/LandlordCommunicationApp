package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.ChatScreen.ChatScreenActivity;
import com.app.landlordcommunication.views.ResidencesList.ResidencesListActivity;
import com.app.landlordcommunication.views.LoginScreen.LoginScreenActivity;
import com.app.landlordcommunication.views.LoginScreen.RealLoginScreenActivity;
import com.app.landlordcommunication.views.MainMenu.MainMenuActivity;
import com.app.landlordcommunication.views.ResidenceOverview.ResidenceOverviewActivity;
import com.app.landlordcommunication.views.UserDetails.UserDetailsActivity;
import com.app.landlordcommunication.views.UsersList.UsersListActivity;

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
        @ContributesAndroidInjector(modules = ResidencesListModule.class)
        abstract ResidencesListActivity residencesListActivity();

        @ActivityScoped
        @ContributesAndroidInjector(modules = ResidenceOverviewModule.class)
        abstract ResidenceOverviewActivity residenceOverviewActivity();

        @ActivityScoped
        @ContributesAndroidInjector(modules = UsersListModule.class)
        abstract UsersListActivity usersListActivity();

        @ActivityScoped
        @ContributesAndroidInjector(modules = ChatScreenModule.class)
        abstract ChatScreenActivity chatScreenActivity();

        @ActivityScoped
        @ContributesAndroidInjector(modules = UserDetailsModule.class)
        abstract UserDetailsActivity userDetailsActivity();

        @ActivityScoped
        @ContributesAndroidInjector(modules = MainMenuModule.class)
        abstract MainMenuActivity mainMenuActivity();

}
