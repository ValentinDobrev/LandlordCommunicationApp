package com.app.landlordcommunication.views.MainMenu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.views.HomePage.HomePageActivity;
import com.app.landlordcommunication.views.LoginScreen.RealLoginScreenActivity;
import com.app.landlordcommunication.views.UsersList.UsersListActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainMenuFragment extends Fragment implements MainMenuContracts.View {

    @BindView(R.id.menu_tv_name)
    TextView mUserNameTextView;

    @BindView(R.id.menu_home_btn)
    Button mHomeButton;

    @BindView(R.id.menu_users_btn)
    Button mUsersButton;

    @BindView(R.id.menu_logout_btn)
    Button mLogoutButton;

    private MainMenuContracts.Presenter mPresenter;

    @Inject
    public MainMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadUser();
    }

    @Override
    public void setPresenter(MainMenuContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showUser(User user) {
        String text = "Greetings, " + user.getFirstName() + " " + user.getSurname();
        int a = 2;
        mUserNameTextView.setText(text);
    }

    @Override
    public void showUsers() {
        Intent intent = new Intent(getContext(), UsersListActivity.class);
        startActivity(intent);
    }

    @Override
    public void showHome(List<Residence> residences) {
        Intent intent = new Intent(getContext(), HomePageActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLoginMenu() {
        Intent intent = new Intent(getContext(), RealLoginScreenActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.menu_home_btn})
    public void homeButtonClick() {
        mPresenter.selectHome();
    }

    @OnClick({R.id.menu_users_btn})
    public void usersButtonClick() {
        showUsers();
    }

    @OnClick({R.id.menu_logout_btn})
    public void logoutButtonClick() {
        Constants.CURRENT_USER_ID = -1;
        showLoginMenu();
    }
}
