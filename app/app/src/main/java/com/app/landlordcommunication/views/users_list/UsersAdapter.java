package com.app.landlordcommunication.views.users_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.User;

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

        @BindView(R.id.tv_user_name)
        TextView mUserNameTextView;

        private OnUserClickListener mOnClickListener;
        private User mUser;

        UserViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(User user) {
            String fullName = user.getFirstName() + " " + user.getSurname();
            mUserNameTextView.setText(fullName);
            mUser = user;
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
