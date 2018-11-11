package com.app.landlordcommunication.views.ChatScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.HomePage.HomePageFragment;
import com.app.landlordcommunication.views.base.BaseActivity;

import javax.inject.Inject;

public class ChatScreenActivity extends BaseActivity {

    public static boolean isActive = false;

    @Inject
    ChatScreenFragment mChatScreenFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);

        setupDrawer();
        setupMainFragment(mChatScreenFragment);
    }

    @Override
    protected void onStart() {
        super.onStart();
        isActive = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isActive = false;
    }

    @Override
    public long getIdentifier() {
        return 0;
    }
}
