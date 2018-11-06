package com.app.landlordcommunication.diconfig;

import com.app.landlordcommunication.views.UserDetails.RatingDialog;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RatingDialogModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract RatingDialog ratingDialog();
}
