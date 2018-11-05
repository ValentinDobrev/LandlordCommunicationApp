package com.app.landlordcommunication.views.LoginScreen;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.HomePage.HomePageActivity;
import com.app.landlordcommunication.views.UsersList.UsersListActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginScreenFragment extends Fragment {

    @BindView(R.id.btn_show_users)
    Button mShowUsersButton;

    @Inject
    public LoginScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_screen, container, false);

        ButterKnife.bind(this, view);


        return view;
    }


    @OnClick({R.id.login_button})
    public void loginButtonClick(){
        Intent intent = new Intent(getContext(), HomePageActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.btn_show_users})
    public void showUsersButtonClick() {
        Intent intent = new Intent(getContext(), UsersListActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.real_login_button})
    public void realLoginButtonClick(){
        Intent intent = new Intent(getContext(), RealLoginScreenActivity.class);
        startActivity(intent);
    }


}
