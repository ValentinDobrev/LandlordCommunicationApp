package com.app.landlordcommunication.views.UsersList;

import android.os.Bundle;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class UsersListActivity extends BaseActivity {

    @Inject
    UsersListFragment mUsersListFragment;

    @Inject
    UsersListContracts.Presenter mUsersListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        ButterKnife.bind(this);

        setupDrawer();

        mUsersListFragment.setPresenter(mUsersListPresenter);

        setupMainFragment(mUsersListFragment);
    }

    @Override
    public long getIdentifier() {
        return Constants.USERS_LIST_IDENTIFIER;
    }
}
