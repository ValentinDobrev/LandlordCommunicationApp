package com.app.landlordcommunication.views.ChatScreen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.async.base.SchedulerProvider;
import com.app.landlordcommunication.models.AuthorisationInfo;
import com.app.landlordcommunication.models.Message;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.services.message.base.MessageService;
import com.app.landlordcommunication.services.user.base.UserService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class ChatScreenPresenter implements ChatScreenContracts.Presenter{

    private final MessageService mMessageService;
    private final SchedulerProvider mSchedulerProvider;
    private ChatScreenContracts.View mView;

    @Inject
    public ChatScreenPresenter(MessageService mMessageService, SchedulerProvider mSchedulerProvider) {
        this.mMessageService = mMessageService;
        this.mSchedulerProvider = mSchedulerProvider;
    }

    @Override
    public void subscribe(ChatScreenContracts.View view) {
        mView = view;
    }

    @Override
    public void loadMessages() {
        mView.showLoading();
        Disposable observable = Observable.create((ObservableOnSubscribe<List<Message>>) emitter ->{
            List<Message> messages = mMessageService
                    .getAllMessagesBetweenReceiverAndSender(
                            Constants.CURRENT_USER_ID,
                            Constants.TEST_CHATTEE_USER_ID
                    );
            emitter.onNext(messages);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(
                        this::presentMessagesToView
                );

    }
    @Override
    public void sendMessage(Message message) {
        Disposable observable = Observable.create((ObservableOnSubscribe<Message>) emitter ->{
            Message testMessage = mMessageService.sendMessage(message);
            emitter.onNext(testMessage);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(
                        this::presentMessageToView
                );
    }

    private void presentMessageToView(Message message){
        mView.showMessage(message);
    }


    private void presentMessagesToView(List<Message> messages) {
        if(messages.isEmpty()){
            mView.showEmptyList();
        }else{
            mView.showMessages(messages);
        }
    }


}
