package com.app.landlordcommunication.views.ResidencesList;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.views.ResidenceOverview.ResidenceOverviewActivity;

import java.util.List;

import javax.inject.Inject;


import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;


public class ResidencesListFragment extends DaggerFragment implements ResidencesListContracts.View, ResidencesAdapter.OnResidenceClickListener {

    @BindView(R.id.rv_residences)
    RecyclerView mResidencesView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

    User loggedUser;

    @Inject
    ResidencesAdapter mResidencesAdapter;

    private LinearLayoutManager mLayoutManager;
    private ResidencesListContracts.Presenter mPresenter;


    @Inject
    public ResidencesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        ButterKnife.bind(this, view);

        mResidencesAdapter.setOnResidenceClickListener(this);

        mResidencesView.setAdapter(mResidencesAdapter);
        mLayoutManager = new LinearLayoutManager(getContext());
        mResidencesView.setLayoutManager(mLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadResidences();
        mPresenter.loadUser();
    }

    @Override
    public void showUser(User user) {
        setLoggedUser(user);
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public void setPresenter(ResidencesListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showResidences(List<Residence> residences) {
        mResidencesAdapter.clear();
        mResidencesAdapter.addAll(residences);
        mResidencesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyList() {
        Toast.makeText(getContext(),
                "NO RESIDENCES TO SHOW",
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
        mResidencesView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mResidencesView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    public void showResidenceOverview(Residence residence) {
        Constants.TEST_RESIDENCE_ID = residence.getResidenceId();
        Intent intent = new Intent(getContext(), ResidenceOverviewActivity.class);
        intent.putExtra("residenceAddress", residence.getAddress());
        intent.putExtra("residenceRent", residence.getRent());
        intent.putExtra("residenceDueDate", residence.getDueDate());
        intent.putExtra("residencePicture", residence.getResidencePicture());
        intent.putExtra("loggedUserPicture", loggedUser.getUserPicture());
        startActivity(intent);
    }

    @Override
    public void onClick(Residence residence) {
        mPresenter.selectResidence(residence);
    }
}
