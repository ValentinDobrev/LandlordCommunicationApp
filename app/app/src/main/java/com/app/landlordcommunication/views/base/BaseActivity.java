package com.app.landlordcommunication.views.base;




import android.support.v4.app.Fragment;

import com.app.landlordcommunication.R;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    public void setupDrawer(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.drawer_toolbar, fragment).commit();
    }

    public abstract void setupMainFragment();

    public abstract long getIdentifier();

}

