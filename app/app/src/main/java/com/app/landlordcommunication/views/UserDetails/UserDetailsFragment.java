package com.app.landlordcommunication.views.UserDetails;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.models.UserRating;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
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

        mRatingButton.setOnClickListener((click) -> openRatingDialog());
        mUserRating.setIsIndicator(true);

        return view;
    }

    private void openRatingDialog() {
        RatingDialog ratingDialog = new RatingDialog();
        ratingDialog.show(getFragmentManager(), "rating dialog");
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
        mUserRating.setRating((float)rating.getRating());
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
