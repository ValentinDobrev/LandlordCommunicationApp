package com.app.landlordcommunication.views.LoginScreen;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.LoginInfo;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.views.HomePage.HomePageActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RealLoginScreenFragment extends Fragment implements LoginScreenContracts.View{

    @Inject
    LoginScreenContracts.Presenter mPresenter;

    @BindView(R.id.et_user_name)
    EditText mUserName;

    @BindView(R.id.et_password)
    EditText mPassword;

    @Inject
    public RealLoginScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_real_login_screen, container, false);

        ButterKnife.bind(this,view);

        return view;
    }

    @OnClick({R.id.real_login_button})
    public void realLoginButtonClick(){

        LoginInfo loginInfo = new LoginInfo(mUserName.getText().toString(), mPassword.getText().toString());

        verifyUser(loginInfo);

    }

    @Override
    public void setPresenter(LoginScreenContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void showError(Throwable e) {
      /*  Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();*/
    }

    @Override
    public void verifyUser(LoginInfo loginInfo) {
         mPresenter.checkUserInDb(loginInfo);
    }

    @Override
    public void startHomeScreen() {
        Intent intent = new Intent(getContext(), HomePageActivity.class);

        startActivity(intent);
    }

    @Override
    public void startTenantHomeScreen() {
        //TODO modify this intent when we have the two differing screens
        Intent intent = new Intent(getContext(), HomePageActivity.class);
        startActivity(intent);
    }
}
