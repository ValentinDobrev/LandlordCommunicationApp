package com.app.landlordcommunication.views.ResidenceOverview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.landlordcommunication.R;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResidenceOverviewFragment extends Fragment {


    @Inject
    public ResidenceOverviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_residence_overview, container, false);
    }

}
