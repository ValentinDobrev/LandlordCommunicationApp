package com.app.landlordcommunication.views.HomePage;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.ResidenceOverview.ResidenceOverviewActivity;

import javax.inject.Inject;
import javax.inject.Named;


import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends DaggerFragment {

    /*@BindView(R.id.test_button)
    Button mTestButton;*/


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


        return view;
    }

 @OnClick({R.id.test_button})
 public void launchResidenceOverviewActivity(){

     Intent intent = new Intent(getContext(), ResidenceOverviewActivity.class);

     startActivity(intent);
 }

}
