package com.app.landlordcommunication.views.LoginScreen;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.app.landlordcommunication.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class RealLoginScreenActivity extends DaggerAppCompatActivity {

    @Inject
    RealLoginScreenFragment mLoginScreenFragment;

    @Inject
    LoginScreenContracts.Presenter mLoginScreenPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_login_screen);

        mLoginScreenFragment.setPresenter(mLoginScreenPresenter);

        setMainFragment(mLoginScreenFragment);

    }

    private void setMainFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.real_login_screen_fragment, fragment).commit();
    }
}
