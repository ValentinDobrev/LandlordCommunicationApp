package com.app.landlordcommunication.views.base;




import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.DrawerFragment;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    public void setupDrawer(DrawerFragment fragment){

       fragment.getFragmentManager().beginTransaction().replace(R.id.drawer_toolbar, fragment).commit();

    }

    public abstract void setupMainFragment();

    public abstract long getIdentifier();

}

