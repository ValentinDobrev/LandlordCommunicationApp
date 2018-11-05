package com.app.landlordcommunication.views.HomePage;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.views.ResidenceOverview.ResidenceOverviewActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;


import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;


public class HomePageFragment extends DaggerFragment implements HomePageContracts.View, AdapterView.OnItemClickListener {

    @BindView(R.id.listView_residences)
    ListView mResidencesView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

    @Inject
//    @Named("baseServerUrlRepository")
    HomePageContracts.Presenter mPresenter;

    ArrayAdapter<Residence> mResidencesAdapter;


    @Inject
    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        ButterKnife.bind(this, view);

        mResidencesAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadResidences();
        showResidences();
    }

    @Override
    public void setPresenter(HomePageContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showResidences() {
        mResidencesView.setAdapter(mResidencesAdapter);
        mResidencesView.setOnItemClickListener(this);
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
        startActivity(intent);
    }

    @Override
    public void addResidences(List<Residence> Residences) {
        mResidencesAdapter.clear();
        mResidencesAdapter.addAll(Residences);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Residence residence = mResidencesAdapter.getItem(position);

        onClick(residence);
    }

    private void onClick(Residence residence) {
        mPresenter.selectResidence(residence);
    }
}
