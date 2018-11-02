package com.app.landlordcommunication.views.ResidenceOverview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.DrawerFragment;
import com.app.landlordcommunication.views.base.BaseActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class ResidenceOverviewActivity extends BaseActivity {

    @Inject
    ResidenceOverviewFragment mResidenceOverviewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residence_overview);


        setupDrawer();

        setupMainFragment(mResidenceOverviewFragment);

    }

    @Override
    public long getIdentifier() {
        return 0;
    }
}
