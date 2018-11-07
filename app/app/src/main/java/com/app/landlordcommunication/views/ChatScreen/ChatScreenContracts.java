package com.app.landlordcommunication.views.ChatScreen;

import android.graphics.Bitmap;

import com.app.landlordcommunication.models.Message;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;

import java.util.List;

public interface ChatScreenContracts {

    interface View{

        void setPresenter(Presenter presenter);

        void showMessages(List<Message> messages);

        void showEmptyList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        //void addMessage(List<Message> messages);

    }

    interface Presenter{

        void subscribe(View view);

        void loadMessages();

    }

}
