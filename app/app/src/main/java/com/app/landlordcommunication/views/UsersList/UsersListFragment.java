package com.app.landlordcommunication.views.UsersList;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.views.UserDetails.UserDetailsActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import dagger.android.support.DaggerFragment;

public class UsersListFragment extends DaggerFragment implements UsersListContracts.View, UsersAdapter.OnUserClickListener {

    @BindView(R.id.rv_users)
    RecyclerView mUsersView;

    @BindView(R.id.ul_loading)
    ProgressBar mLoadingView;

    @BindView(R.id.et_filter)
    EditText mFilterEditText;

    @Inject
    UsersAdapter mUsersAdapter;

    private UsersListContracts.Presenter mPresenter;
    private LinearLayoutManager mUsersViewLayoutManager;

    @Inject
    public UsersListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users_list, container, false);

        ButterKnife.bind(this, view);

        mUsersAdapter.setOnUserClickListener(this);

        mUsersView.setAdapter(mUsersAdapter);
        mUsersViewLayoutManager = new LinearLayoutManager(getContext());
        mUsersView.setLayoutManager(mUsersViewLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadUsers();
    }

    @Override
    public void setPresenter(UsersListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showUsers(List<User> users) {
        mUsersAdapter.clear();
        mUsersAdapter.addAll(users);
        mUsersAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyList() {
        Toast.makeText(getContext(),
                "No users found",
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLoading() {
        mUsersView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mUsersView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    public void showUserDetails(User user) {
        Intent intent = new Intent(getContext(), UserDetailsActivity.class);
        intent.putExtra(Constants.USERS_EXTRA_STRING, user);
        startActivity(intent);
    }

    @Override
    public void onClick(User user) {
        mPresenter.selectUser(user);
    }

    @OnTextChanged(R.id.et_filter)
    public void onTextChanged() {
        String pattern = mFilterEditText.getText().toString();
        mPresenter.filterUsers(pattern);
    }
}
