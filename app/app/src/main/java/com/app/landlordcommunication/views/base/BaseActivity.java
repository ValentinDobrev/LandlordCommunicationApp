package com.app.landlordcommunication.views.base;




import android.support.v4.app.Fragment;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.DrawerFragment;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity  {

    public void setupDrawer(){

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.drawer_toolbar_fragment, DrawerFragment.newInstance())
                .commit();

    }

    public void setupMainFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, fragment)
                .commit();
    }

    public abstract long getIdentifier();
}

