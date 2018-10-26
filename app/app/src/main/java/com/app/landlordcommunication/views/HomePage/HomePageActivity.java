package com.app.landlordcommunication.views.HomePage;


import android.os.Bundle;


import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.DrawerFragment;
import com.app.landlordcommunication.views.base.BaseActivity;

import javax.inject.Inject;

public class HomePageActivity extends BaseActivity {

    public static final long IDENTIFIER = 1;

    @Inject
    DrawerFragment mDrawerFragment;

    @Inject
    HomePageFragment mHomePageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        setupDrawer(mDrawerFragment);
        setupMainFragment();


    }


    @Override
    public void setupMainFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, mHomePageFragment).commit();
    }

    @Override
    public long getIdentifier() {
        return 0;
    }
}
