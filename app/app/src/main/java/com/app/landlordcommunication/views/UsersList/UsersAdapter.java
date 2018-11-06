package com.app.landlordcommunication.views.UsersList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.models.UserRating;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    private List<User> mUsers;
    private OnUserClickListener mOnUserClickListener;

    @Inject
    public UsersAdapter() {
        mUsers = new ArrayList<>();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    public void onBindViewHolder(@NonNull UserViewHolder holder, int position){
        holder.setOnClickListener(mOnUserClickListener);
        holder.bind(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public User getItem(int position) {
        return mUsers.get(position);
    }

    public void clear() {
        mUsers.clear();
    }

    public void addAll(List<User> users) {
        mUsers.addAll(users);
    }

    public void setOnUserClickListener(OnUserClickListener onUserClickListener) {
        mOnUserClickListener = onUserClickListener;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ud_tv_user_first_name)
        TextView mUserFirstNameTextView;

        @BindView(R.id.ud_tv_user_surname)
        TextView mUserSurnameTextView;

        @BindView(R.id.iv_user)
        ImageView mUserImage;

        @BindView(R.id.iv_rating)
        ImageView mRatingStarImage;

        @BindView(R.id.tv_rating)
        TextView mRatingValue;

        private OnUserClickListener mOnClickListener;
        private User mUser;

        UserViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(User user) {
            mUserFirstNameTextView.setText(user.getFirstName());
            mUserSurnameTextView.setText(user.getSurname());
            mUserImage.setImageBitmap(convertUserImageToBitmap(user.getUserPicture()));
            mRatingStarImage.setImageResource(R.drawable.rating);
            mRatingValue.setText(getUserRating(user));

            mUser = user;
        }

        // returns String value of the user rating
        String getUserRating(User user) {
            double result = 0.0;
            List<Rating> userRatingRecord = user.getRatingsTaken();
            if (!userRatingRecord.isEmpty()) {

                for (Rating r : userRatingRecord) {
                    result += r.getRating();
                }

                result = result / userRatingRecord.size();
                String ratingString = String.valueOf(result);

                if (ratingString.length() > 4) {
                    ratingString = ratingString.substring(0, 4);
                }

                return ratingString;
            }
            else {
                return "";
            }
        }

        private Bitmap convertUserImageToBitmap(String userImage) {
            InputStream stream = new ByteArrayInputStream(Base64.decode(userImage.getBytes(), Base64.DEFAULT));

            return BitmapFactory.decodeStream(stream);
        }

        @OnClick
        public void onClick() {
            mOnClickListener.onClick(mUser);
        }

        public void setOnClickListener(OnUserClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface OnUserClickListener {
        void onClick(User user);
    }
}
