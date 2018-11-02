package com.app.landlordcommunication.views.LoginScreen;


import android.os.Bundle;

import com.app.landlordcommunication.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;



public class LoginScreenActivity extends DaggerAppCompatActivity  {

    @Inject
    LoginScreenFragment loginScreenFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        getSupportFragmentManager().beginTransaction().replace(R.id.login_screen_fragment, loginScreenFragment).commit();

    }

}
