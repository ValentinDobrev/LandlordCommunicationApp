package com.app.landlordcommunication.views.ResidencesList;


import android.os.Bundle;


import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ResidencesListActivity extends BaseActivity {

    @Inject
    ResidencesListFragment mResidencesListFragment;

    @Inject
    ResidencesListContracts.Presenter mHomePagePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ButterKnife.bind(this);

        setupDrawer();

        mResidencesListFragment.setPresenter(mHomePagePresenter);

        setupMainFragment(mResidencesListFragment);


    }

    @Override
    public long getIdentifier() {
        return Constants.RESIDENCES_LIST_IDENTIFIER;
    }
}
