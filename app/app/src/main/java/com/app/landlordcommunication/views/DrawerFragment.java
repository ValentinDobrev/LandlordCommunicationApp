package com.app.landlordcommunication.views;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.ResidenceOverview.ResidenceOverviewActivity;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerFragment extends android.support.v4.app.Fragment {

    @BindView(R.id.drawer_toolbar)
    Toolbar mDrawer;

    @Inject
    public DrawerFragment() {
        // Required empty public constructor
    }

    public static DrawerFragment newInstance() {
        return new DrawerFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drawer, container, false);


        ButterKnife.bind(this, view);
        setupDrawer();


        return view;

    }

    public void setupDrawer() {

        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(ResidenceOverviewActivity.IDENTIFIER).withName("Add Movie");

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(getActivity())
                .withToolbar(mDrawer)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem()
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        long identifier = drawerItem.getIdentifier();


                        if (identifier == ResidenceOverviewActivity.IDENTIFIER) {
                            //the below checks if the drawer fragment is in the activity that is being clicked on
                            //in a very clunky way, but the only one I could think of, might need optimisation or at least
                            //moving the if-else logic in a method.
                            if (getActivity().getClass().equals(ResidenceOverviewActivity.class))
                                return false;

                            else {
                                Intent intent = new Intent(getContext(), ResidenceOverviewActivity.class);

                                startActivity(intent);
                                return true;
                            }
                        }

                        return false;

                    }
                })
                .build();
    }

}
