package com.app.landlordcommunication.views.ResidenceOverview;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.views.ChatScreen.ChatScreenActivity;
import com.app.landlordcommunication.views.HomePage.HomePageActivity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResidenceOverviewFragment extends Fragment     implements ResidenceOverviewContracts.View,
        UsersAdapter.OnUserClickListener {

    @BindView(R.id.imageView_residenceOverview)
    ImageView mResidencePicture;

    @BindView(R.id.textView_addressText)
    TextView mAdressText;

    @BindView(R.id.textView_rentText)
    TextView mRentText;

    @BindView(R.id.textView_dueDateText)
    TextView mDueDateText;

    @BindView(R.id.list)
    RecyclerView mUsersView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

    @BindView(R.id.button_payRent)
    Button mPayRentBtn;

//    @Inject
//    @Named("baseServerUrlUser")
    @Inject
    ResidenceOverviewContracts.Presenter mPresenter;

    private GridLayoutManager mUsersViewLayoutManager;

    @Inject
    UsersAdapter mUsersAdapter;

    //ArrayAdapter<User> mUsersAdapter;

    @Inject
    public ResidenceOverviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_residence_overview, container, false);

        ButterKnife.bind(this, view);

        //mUsersAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1);


        mUsersAdapter.setOnUserClickListener(this);


        mUsersView.setAdapter(mUsersAdapter);
        mUsersViewLayoutManager = new GridLayoutManager(getContext(), 1);
        mUsersView.setLayoutManager(mUsersViewLayoutManager);

        Intent intent = getActivity().getIntent();




        String residencePicture = intent.getStringExtra("residencePicture");
        InputStream stream = new ByteArrayInputStream(Base64.decode(residencePicture.getBytes(), Base64.DEFAULT));

        Bitmap bitmap = BitmapFactory.decodeStream(stream);
        mResidencePicture.setImageBitmap(bitmap);





        String residenceAddress = intent.getStringExtra("residenceAddress");
        //String residenceRent = intent.getStringExtra("residenceRent");
        double residenceRent = intent.getDoubleExtra("residenceRent", 0);
        //String residenceDueDate = intent.getStringExtra("residenceDueDate");
        Date date = (Date)intent.getSerializableExtra("residenceDueDate");

        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        String datee = format.format(Date.parse(date.toString()));

        mAdressText.setText(residenceAddress);
        String stringResidenceRent = "" + residenceRent + " BGN";
        mRentText.setText(stringResidenceRent);
        mDueDateText.setText(datee);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadUsers();
//        showUsers();

    }

    @Override
    public void setPresenter(ResidenceOverviewContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showUsers(List<User> users) {
//        mUsersView.setAdapter(mUsersAdapter);
//
//        mUsersView.setOnItemClickListener(this);

        mUsersAdapter.clear();
        mUsersAdapter.addAll(users);
        boolean flag = showPayRentBtn(users);
        if(flag==true) {
            mPayRentBtn.setVisibility(View.VISIBLE);
        }
        mUsersAdapter.notifyDataSetChanged();

    }

    boolean showPayRentBtn(List<User> users){

        for (User user : users) {
            if(user.getUserId() == Constants.TEST_USER_ID) {
                if (user.getIsTenant() == false) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void showEmptyList() {
        Toast.makeText(getContext(),
                "NO USERS TO SHOW",
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
    public void showResidenceOverviewDetails() {
//        Intent intent = new Intent(getContext(), HomePageActivity.class);
        Intent intent = new Intent(getContext(), ChatScreenActivity.class);
        startActivity(intent);
    }

//    @Override
//    public void addUsers(List<User> users) {
//        mUsersAdapter.clear();
//        mUsersAdapter.addAll(users);
//    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//        User user = mUsersAdapter.getItem(position);
//
//        onClick(user);
//    }

    public void onClick(User user) {
        mPresenter.selectUser(user);
    }

    @OnClick(R.id.button_payRent)
    public void OnBtnClick(){
        mPresenter.selectPayBtn();
    }
}
