package com.app.landlordcommunication.views.HomePage;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.DrawerFragment;
import com.app.landlordcommunication.views.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class HomePageActivity extends BaseActivity {

    @Inject
    DrawerFragment mDrawerFragment;

    @Inject
    HomePageFragment mHomePageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ButterKnife.bind(this);

        setupDrawer(mDrawerFragment);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, mHomePageFragment);

        transaction.commit();

    }

    @Override
    public void setupMainFragment() {

        //TODO Fix this faking null pointer exception, FU DAGGER

      //  getFragmentManager().beginTransaction().replace(R.id.main_fragment, mHomePageFragment).commit();

    }

    @Override
    public long getIdentifier() {
        return 0;
    }
}
