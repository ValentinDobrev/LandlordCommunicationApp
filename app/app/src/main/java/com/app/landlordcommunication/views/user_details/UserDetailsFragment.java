package com.app.landlordcommunication.views.user_details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.User;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

public class UserDetailsFragment extends DaggerFragment implements UserDetailsContracts.View {

    @BindView(R.id.ud_loading)
    ProgressBar mProgressBar;

    @BindView(R.id.ud_tv_user_name)
    TextView mUserName;

    private UserDetailsContracts.Presenter mPresenter;

    @Inject
    public UserDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_details, container, false);

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
    public void showUser(User user) {
        String fullName = user.getFirstName() + " " + user.getSurname();
        mUserName.setText(fullName);
        hideLoading();
    }

    @Override
    public void setPresenter(UserDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }
}
