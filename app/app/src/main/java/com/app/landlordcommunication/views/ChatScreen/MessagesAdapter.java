package com.app.landlordcommunication.views.ChatScreen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.Message;
import com.app.landlordcommunication.models.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>{


    private List<Message> mMessages;

    @Inject
    public MessagesAdapter() {
        mMessages = new ArrayList<>();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_row, parent, false);
        return new MessageViewHolder(view);
    }

    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position){
        //holder.setOnClickListener(mOnUserClickListener);
        holder.bind(mMessages.get(position));
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    public Message getItem(int position) {
        return mMessages.get(position);
    }

    public void clear() {
        mMessages.clear();
    }

    public void addAll(List<Message> messages) {
        mMessages.addAll(messages);
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.message_textView)
        TextView mMessageTextView;

        @BindView(R.id.time_sent_textView)
        TextView mTimeSentTextView;

        @BindView(R.id.list_image)
        ImageView mUserImg;

        private Message mMessage;

        MessageViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(Message message) {

            mMessageTextView.setText(message.getText());
            mTimeSentTextView.setText(message.getSentDate().toString());
            mMessage = message;
        }
    }
}
