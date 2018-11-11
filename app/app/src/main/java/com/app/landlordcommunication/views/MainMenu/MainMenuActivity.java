package com.app.landlordcommunication.views.MainMenu;

import android.os.Bundle;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class MainMenuActivity extends DaggerAppCompatActivity {

    @Inject
    MainMenuFragment mMainMenuFragment;

    @Inject
    MainMenuContracts.Presenter mMainMenuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ButterKnife.bind(this);

        mMainMenuFragment.setPresenter(mMainMenuPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_menu_fragment, mMainMenuFragment)
                .commit();
    }

    public long getIdentifier() {
        return Constants.MAIN_MENU_IDENTIFIER;
    }
}
