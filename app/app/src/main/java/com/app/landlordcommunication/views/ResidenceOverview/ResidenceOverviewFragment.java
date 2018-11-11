package com.app.landlordcommunication.views.ResidenceOverview;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.views.ChatScreen.ChatScreenActivity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResidenceOverviewFragment extends Fragment implements ResidenceOverviewContracts.View,
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

    @Inject
    ResidenceOverviewContracts.Presenter mPresenter;

    private GridLayoutManager mUsersViewLayoutManager;

    @Inject
    UsersAdapter mUsersAdapter;

    private String pictureForChatter;

    @Inject
    public ResidenceOverviewFragment() {
        // Required empty public constructor
    }

    Residence testResidence;
    private int mResidenceId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_residence_overview, container, false);
        ButterKnife.bind(this, view);

        mUsersAdapter.setOnUserClickListener(this);
        mUsersView.setAdapter(mUsersAdapter);
        mUsersViewLayoutManager = new GridLayoutManager(getContext(), 1);
        mUsersView.setLayoutManager(mUsersViewLayoutManager);


        Intent intent = getActivity().getIntent();

        mResidenceId = intent.getIntExtra("residenceId", 0);
        String residencePicture = intent.getStringExtra("residencePicture");
        InputStream stream = new ByteArrayInputStream(Base64.decode(residencePicture.getBytes(), Base64.DEFAULT));
        Bitmap bitmap = BitmapFactory.decodeStream(stream);
        mResidencePicture.setImageBitmap(bitmap);
        String residenceAddress = intent.getStringExtra("residenceAddress");
        double residenceRent = intent.getDoubleExtra("residenceRent", 0);
        Date date = (Date)intent.getSerializableExtra("residenceDueDate");
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        String datee = format.format(Date.parse(date.toString()));
        mAdressText.setText(residenceAddress);
        String stringResidenceRent = "" + residenceRent + " BGN";
        mRentText.setText(stringResidenceRent);
        mDueDateText.setText(datee);
        pictureForChatter = intent.getStringExtra("loggedUserPicture");

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadUsers();

    }

    @Override
    public void setPresenter(ResidenceOverviewContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showUsers(List<User> users) {

        mUsersAdapter.clear();
        mUsersAdapter.addAll(users);
        boolean flag = showPayRentBtn(users);
        if(flag==true) {
            mPayRentBtn.setVisibility(View.VISIBLE);
        }
        mUsersAdapter.notifyDataSetChanged();

    }

    @Override
    public void showResidence(Residence residence) {
        setTestResidence(residence);
    }

    @Override
    public void showLoadedResidence(Residence residence) {
        Date date = residence.getDueDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        String newDate = sdf.format(Date.parse(date.toString()));
        mDueDateText.setText(newDate);
    }

    public Residence getTestResidence() {
        return testResidence;
    }

    public void setTestResidence(Residence testResidence) {
        this.testResidence = testResidence;
    }

    boolean showPayRentBtn(List<User> users){

        for (User user : users) {
            if(user.getUserId() == Constants.CURRENT_USER_ID) {
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
    public void showChatScreen(User chattee) {
        Constants.TEST_CHATTEE_USER_ID = chattee.getUserId();
        Intent intent = new Intent(getContext(), ChatScreenActivity.class);
        intent.putExtra("chatteePicture", chattee.getUserPicture());
        intent.putExtra("chatterPicture", pictureForChatter);
        startActivity(intent);
    }

    public void onClick(User user) {
        mPresenter.selectUser(user);
    }

    @OnClick(R.id.button_payRent)
    public void OnBtnClick() {
        mPresenter.loadCorrectDates();
        mPresenter.loadResidence(mResidenceId);
        Toast.makeText(getContext(), "You have paid your rent.", Toast.LENGTH_LONG).show();
    }
}
