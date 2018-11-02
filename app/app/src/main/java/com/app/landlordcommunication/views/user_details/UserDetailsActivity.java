package com.app.landlordcommunication.views.user_details;

import android.os.Bundle;
import android.widget.TextView;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.base.BaseActivity;

public class UserDetailsActivity extends BaseActivity {

    TextView mUserNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        mUserNameTextView = findViewById(R.id.tv_ud_user_name);
    }

    @Override
    public long getIdentifier() {
        return 0;
    }
}
