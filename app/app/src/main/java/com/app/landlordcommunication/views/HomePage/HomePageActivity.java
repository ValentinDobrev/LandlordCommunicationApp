package com.app.landlordcommunication.views.HomePage;


import android.os.Bundle;
import android.support.v4.app.Fragment;


import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.DrawerFragment;
import com.app.landlordcommunication.views.base.BaseActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class HomePageActivity extends BaseActivity {

    public static final long IDENTIFIER = 1;

    @Inject
    HomePageFragment mHomePageFragment;

    @Inject
    HomePageContracts.Presenter mHomePagePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        setupDrawer();

        mHomePageFragment.setPresenter(mHomePagePresenter);

        setupMainFragment(mHomePageFragment);


    }



    @Override
    public long getIdentifier() {
        return 0;
    }
}
