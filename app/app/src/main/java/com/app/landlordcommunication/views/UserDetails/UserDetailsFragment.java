package com.app.landlordcommunication.views.UserDetails;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.models.UserRating;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerFragment;

public class UserDetailsFragment extends DaggerFragment implements UserDetailsContracts.View {

    @BindView(R.id.ud_loading)
    ProgressBar mProgressBar;

    @BindView(R.id.ud_tv_user_name)
    TextView mUserName;

    @BindView(R.id.ud_user_image)
    ImageView mUserImage;

    @BindView(R.id.user_rating)
    RatingBar mUserRating;

    @BindView(R.id.rating_button)
    Button mRatingButton;

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

        mUserRating.setIsIndicator(true);

        return view;
    }

    @OnClick({R.id.rating_button})
    public void onRatingButtonClick() {
        boolean sameUser = mPresenter.checkIfUserIsTheSame();
        if (sameUser) {
            Toast.makeText(getContext(), "You can't rate yourself!", Toast.LENGTH_LONG)
                    .show();
        } else {
           openRatingDialog();
        }
    }


    private void openRatingDialog() {
        final int[] givenRating = new int[1];
        final AlertDialog.Builder popDialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_rating, null);

        popDialog.setTitle("Vote!");
        popDialog.setView(view);

        RatingBar ratingBar = getActivity().findViewById(R.id.dialog_rating_bar);

        popDialog.setPositiveButton(android.R.string.ok, (dialog, which) -> {
            givenRating[0] = ratingBar.getProgress();
            dialog.dismiss();
        })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    dialog.cancel();
                });

        popDialog.create();
        popDialog.show();
//TODO never used? the below might need to be inside a lambda
        int ratingValue = givenRating[0];
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadUser();
        mPresenter.loadUserRating();
    }

    @Override
    public void showUser(User user) {
        String fullName = user.getFirstName() + " " + user.getSurname();
        mUserName.setText(fullName);
        mUserImage.setImageBitmap(convertUserImageToBitmap(user.getUserPicture()));
    }

    @Override
    public void showRating(UserRating rating) {
        mUserRating.setRating((float) rating.getRating());
    }

    private Bitmap convertUserImageToBitmap(String userImage) {
        InputStream stream = new ByteArrayInputStream(Base64.decode(userImage.getBytes(), Base64.DEFAULT));

        return BitmapFactory.decodeStream(stream);
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
