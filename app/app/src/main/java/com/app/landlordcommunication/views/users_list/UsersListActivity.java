package com.app.landlordcommunication.views.users_list;

import android.content.Intent;
import android.os.Bundle;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.views.base.BaseActivity;
import com.app.landlordcommunication.views.user_details.UserDetailsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class UsersListActivity extends BaseActivity implements UsersListContracts.Navigator {

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

        mUsersListFragment.setNavigator(this);
        mUsersListFragment.setPresenter(mUsersListPresenter);

        setupMainFragment(mUsersListFragment);
    }

    @Override
    public long getIdentifier() {
        return Constants.USERS_LIST_IDENTIFIER;
    }

    @Override
    public void navigateWith(User user) {
        Intent intent = new Intent(this, UserDetailsActivity.class);
        String userName = user.getFirstName() + " " + user.getSurname();
        intent.putExtra(Constants.USERS_EXTRA_STRING, userName);
        startActivity(intent);
    }
}
