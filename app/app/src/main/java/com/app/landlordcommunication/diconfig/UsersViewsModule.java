package com.app.landlordcommunication.diconfig;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.app.landlordcommunication.views.users_list.UsersAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class UsersViewsModule {
    @Provides
    public RecyclerView.Adapter<UsersAdapter.UserViewHolder> UserArrayAdapter(Context context) {
        return new UsersAdapter();
    }
}
