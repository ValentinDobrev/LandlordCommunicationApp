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
import com.app.landlordcommunication.views.HomePage.HomePageActivity;
import com.app.landlordcommunication.views.MainMenu.MainMenuActivity;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RealLoginScreenFragment extends Fragment implements LoginScreenContracts.View, Validator.ValidationListener {

    @Inject
    LoginScreenContracts.Presenter mPresenter;

    @NotEmpty
    @Email
    @BindView(R.id.et_user_name)
    EditText mUserName;

    @Password(min = 6, scheme = Password.Scheme.ANY)
    @BindView(R.id.et_password)
    EditText mPassword;

    Validator mValidator;

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

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);


        return view;
    }

    @OnClick({R.id.real_login_button})
    public void realLoginButtonClick(){
        mValidator.validate();
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
        Toast.makeText(getContext(), "Network delays encountered, please try again later.", Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void verifyUser(LoginInfo loginInfo) {
         mPresenter.checkUserInDb(loginInfo);
    }

    @Override
    public void startHomeScreen() {
        Intent intent = new Intent(getContext(), MainMenuActivity.class);

        startActivity(intent);
    }

    @Override
    public void onValidationSucceeded() {
        LoginInfo loginInfo = new LoginInfo(mUserName.getText().toString(), mPassword.getText().toString());

        verifyUser(loginInfo);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getContext());
            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }
        }
    }


}

