package com.app.landlordcommunication.views.ResidenceOverview;

import android.os.Bundle;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.base.BaseActivity;

import javax.inject.Inject;

public class ResidenceOverviewActivity extends BaseActivity {

    @Inject
    ResidenceOverviewFragment mResidenceOverviewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residence_overview);


        setupDrawer();

        setTitle("My Residence");

        setupMainFragment(mResidenceOverviewFragment);
    }

    @Override
    public long getIdentifier() {
        return Constants.RESIDENCE_OVERVIEW_IDENTIFIER;
    }
}
