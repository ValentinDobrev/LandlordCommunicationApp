package com.app.landlordcommunication.views.LoginScreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.landlordcommunication.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class RealLoginScreenFragment extends Fragment implements LoginScreenContracts.View{

    @Inject
    LoginScreenContracts.Presenter mPresenter;


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



    }

    @Override
    public void setPresenter(LoginScreenContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void verifyUser(String email) {
         mPresenter.checkUserInDb(email);
    }
}
