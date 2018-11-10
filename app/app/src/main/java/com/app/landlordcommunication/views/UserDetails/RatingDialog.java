package com.app.landlordcommunication.views.UserDetails;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;

import com.app.landlordcommunication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RatingDialog extends AppCompatDialogFragment {

    @BindView(R.id.dialog_rating_bar)
    RatingBar mRatingBar;

    private int mRating;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_rating, null);

        builder.setView(view)
                .setTitle("Rate user")
                .setPositiveButton("Ok", (dialog, which) -> {
                    float rating = mRatingBar.getRating();
                    int intRating = (int) rating;
                    setRating(intRating);
                });

        ButterKnife.bind(this, view);

        return builder.create();
    }

    public int getRating() {
        return mRating;
    }

    private void setRating(int rating) {
        mRating = rating;
    }
}
