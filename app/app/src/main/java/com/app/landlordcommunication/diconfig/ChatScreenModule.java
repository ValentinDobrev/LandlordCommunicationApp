package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.ChatScreen.ChatScreenFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ChatScreenModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract ChatScreenFragment chatScreenFragment();

}
