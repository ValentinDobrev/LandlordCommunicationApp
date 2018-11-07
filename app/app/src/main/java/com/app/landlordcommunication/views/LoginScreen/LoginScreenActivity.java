package com.app.landlordcommunication.views.LoginScreen;


import android.os.Bundle;

import com.app.landlordcommunication.R;
import com.google.firebase.messaging.FirebaseMessaging;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;



public class LoginScreenActivity extends DaggerAppCompatActivity  {

    private static final String TOPIC = "JavaSampleApproach";
    @Inject
    LoginScreenFragment loginScreenFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        getSupportFragmentManager().beginTransaction().replace(R.id.login_screen_fragment, loginScreenFragment).commit();

        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC);

    }

}
