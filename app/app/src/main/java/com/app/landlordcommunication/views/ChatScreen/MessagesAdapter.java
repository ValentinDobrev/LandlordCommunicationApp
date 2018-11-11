package com.app.landlordcommunication.views.ChatScreen;

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

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.R;
import com.app.landlordcommunication.async.AsyncSchedulerProvider;
import com.app.landlordcommunication.async.SyncSchedulerProvider;
import com.app.landlordcommunication.async.base.SchedulerProvider;
import com.app.landlordcommunication.models.Message;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.repositories.user.HttpUserRepository;
import com.app.landlordcommunication.services.user.base.UserService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>{


    private List<Message> mMessages;
    public static Bitmap chatteePictureBitmap;
    public static Bitmap chatterPictureBitmap;

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

            if(Constants.CURRENT_USER_ID == message.getReceiverId()) {
                mUserImg.setImageBitmap(getChatteePictureBitmap());
            }else {
                mUserImg.setImageBitmap(getChatterPictureBitmap());

            }
            mMessageTextView.setText(message.getText());
            Date date = message.getSentDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
            String dateSent = format.format(Date.parse(date.toString()));
            mTimeSentTextView.setText(dateSent);
            mMessage = message;
        }
    }

    void setChatteePictureBitmap(Bitmap bitmap){
        this.chatteePictureBitmap = bitmap;
    }

    public static Bitmap getChatteePictureBitmap() {
        return chatteePictureBitmap;
    }

    public static Bitmap getChatterPictureBitmap() {
        return chatterPictureBitmap;
    }

    public void setChatterPictureBitmap(Bitmap bitmapForLoggedUser) {
        MessagesAdapter.chatterPictureBitmap = bitmapForLoggedUser;
    }
}
