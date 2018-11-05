package com.app.landlordcommunication.views.user_details;

import android.content.Intent;
import android.os.Bundle;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.views.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class UserDetailsActivity extends BaseActivity {

    @Inject
    UserDetailsFragment mUserDetailsFragment;

    @Inject
    UserDetailsContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        ButterKnife.bind(this);

        setupDrawer();

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra(Constants.USERS_EXTRA_STRING);

        mPresenter.setUserId(user.getUserId());

        mUserDetailsFragment.setPresenter(mPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ud_main_fragment, mUserDetailsFragment)
                .commit();
    }

    @Override
    public long getIdentifier() {
        return Constants.USER_DETAILS_IDENTIFIER;
    }
}
