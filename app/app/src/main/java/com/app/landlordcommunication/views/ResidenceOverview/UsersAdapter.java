package com.app.landlordcommunication.views.ResidenceOverview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.User;

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
    private User loggedUser;

    @Inject
    public UsersAdapter(){
        mUsers = new ArrayList<>();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_row, parent, false);
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
//        mUsers.addAll(users);

        for (User user : users) {
            if(user.getUserId() == Constants.CURRENT_USER_ID){
//                loggedUser = user;
                continue;
            }else {
                mUsers.add(user);
            }
        }

    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public void setOnUserClickListener(OnUserClickListener onUserClickListener){
        this.mOnUserClickListener = onUserClickListener;
    }

    interface OnUserClickListener {
        void onClick(User user);
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.user_name)
        TextView mUserNameTextView;

        @BindView(R.id.button_openChat)
        Button mOpenChatBtn;

        @BindView(R.id.list_image)
        ImageView mUserImg;

//        @BindView(R.id.email)
//        TextView mUserEmailTextView;

        private OnUserClickListener mOnClickListener;
        private User mUser;

        UserViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(User user) {
            mUserNameTextView.setText(user.getFirstName() + " " + user.getSurname());
            InputStream stream = new ByteArrayInputStream(Base64.decode(user.getUserPicture().getBytes(), Base64.DEFAULT));

            Bitmap bitmap = BitmapFactory.decodeStream(stream);

            mUserImg.setImageBitmap(bitmap);
//            mUserEmailTextView.setText(user.getEmail());
//            mOpenChatBtn.
            //Picasso.get().load(residence.getImage()).into(mResidenceImageView);
            mUser = user;
        }

//        @OnClick
//        public void OnClick(){
//            mOnClickListener.onClick(mUser);
//        }

        @OnClick(R.id.button_openChat)
        public void OnClick(){
            mOnClickListener.onClick(mUser);
        }


        public void setOnClickListener(OnUserClickListener onClickListener){
            mOnClickListener = onClickListener;
        }


    }
}
