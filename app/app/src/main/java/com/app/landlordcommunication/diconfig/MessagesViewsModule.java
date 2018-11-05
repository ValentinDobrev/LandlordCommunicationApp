package com.app.landlordcommunication.diconfig;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.app.landlordcommunication.views.ChatScreen.MessagesAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MessagesViewsModule {
    @Provides
    public RecyclerView.Adapter<MessagesAdapter.MessageViewHolder> MessageArrayAdapter(Context context) {
        return new MessagesAdapter();
    }
}
