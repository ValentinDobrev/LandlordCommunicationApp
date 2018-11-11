package com.app.landlordcommunication.views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.views.ChatScreen.ChatScreenActivity;
import com.app.landlordcommunication.views.MainMenu.MainMenuActivity;
import com.app.landlordcommunication.views.ResidenceOverview.ResidenceOverviewActivity;
import com.app.landlordcommunication.views.ResidencesList.ResidencesListActivity;
import com.app.landlordcommunication.views.UserDetails.UserDetailsActivity;
import com.app.landlordcommunication.views.UsersList.UsersListActivity;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;


import butterknife.BindView;
import butterknife.ButterKnife;

public class DrawerFragment extends android.support.v4.app.Fragment {

    @BindView(R.id.drawer_toolbar)
    Toolbar mDrawer;

    @BindView(R.id.drawer_title)
    TextView mDrawerTitle;

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
        setTitle();

        return view;

    }

    public void setupDrawer() {

        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem myResidences = new PrimaryDrawerItem()
                .withIdentifier(Constants.RESIDENCES_LIST_IDENTIFIER)
                .withName("My Residences")
                .withIcon(R.drawable.drawer_residences);

        PrimaryDrawerItem mainMenu = new PrimaryDrawerItem()
                .withIdentifier(Constants.MAIN_MENU_IDENTIFIER)
                .withName("Main Menu")
                .withIcon(R.drawable.drawer_main_menu);

        PrimaryDrawerItem users = new PrimaryDrawerItem()
                .withIdentifier(Constants.USERS_LIST_IDENTIFIER)
                .withName("All Users")
                .withIcon(R.drawable.drawer_users);

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(getActivity())
                .withToolbar(mDrawer)
                .addDrawerItems(
                        mainMenu,
                        new DividerDrawerItem(),
                        myResidences,
                        new DividerDrawerItem(),
                        users
                )
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {

                    long identifier = drawerItem.getIdentifier();

                    int identifierToInt = (int) identifier;

                    switch (identifierToInt) {

                        case Constants.MAIN_MENU_IDENTIFIER:
                            if (getActivity().getClass().equals(MainMenuActivity.class))
                                return false;
                            else {
                                Intent intent = new Intent(getContext(), MainMenuActivity.class);

                                startActivity(intent);
                                return true;
                            }

                        case Constants.RESIDENCES_LIST_IDENTIFIER:
                            if (getActivity().getClass().equals(ResidencesListActivity.class))
                                return false;
                            else {
                                Intent intent = new Intent(getContext(), ResidencesListActivity.class);

                                startActivity(intent);
                                return true;
                            }

                        case Constants.USERS_LIST_IDENTIFIER:
                            if (getActivity().getClass().equals(UsersListActivity.class))
                                return false;
                            else {
                                Intent intent = new Intent(getContext(), UsersListActivity.class);

                                startActivity(intent);
                                return true;
                            }
                    }

                    return false;

                })
                .build();
    }

    private void setTitle() {

        if (getActivity().getClass().equals(ResidenceOverviewActivity.class)) {
            mDrawerTitle.setText("My Residence");
        }
        else if (getActivity().getClass().equals(ChatScreenActivity.class)) {
            mDrawerTitle.setText("Chat");
        }
        else if (getActivity().getClass().equals(ResidencesListActivity.class)) {
            mDrawerTitle.setText("My Residences");
        }
        else if (getActivity().getClass().equals(UsersListActivity.class)) {
            mDrawerTitle.setText("All Users");
        }
        else if (getActivity().getClass().equals(UserDetailsActivity.class)) {
            mDrawerTitle.setText("User Details");
        }
    }

}
