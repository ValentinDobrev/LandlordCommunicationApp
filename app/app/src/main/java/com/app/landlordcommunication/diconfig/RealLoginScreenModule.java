package com.app.landlordcommunication.diconfig;


import com.app.landlordcommunication.views.LoginScreen.RealLoginScreenFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RealLoginScreenModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract RealLoginScreenFragment realLoginScreenFragment();
}