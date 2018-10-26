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

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginScreenFragment extends Fragment {

//The on-click method works without this bind...? :D
/*    @BindView(R.id.login_button)
    Button mLoginButton;*/


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

}
