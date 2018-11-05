package com.app.landlordcommunication.views.LoginScreen;

import android.content.Intent;

import com.app.landlordcommunication.AndroidApplication;
import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.async.base.SchedulerProvider;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.services.user.base.UserService;
import com.app.landlordcommunication.views.HomePage.HomePageContracts;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class RealLoginScreenPresenter implements LoginScreenContracts.Presenter {

    private final UserService mUserService;
    private final SchedulerProvider mSchedulerProvider;
    private LoginScreenContracts.View mView;


    @Inject
    public RealLoginScreenPresenter(UserService mUserService, SchedulerProvider mSchedulerProvider) {
        this.mUserService = mUserService;
        this.mSchedulerProvider = mSchedulerProvider;
    }

    @Override
    public void subscribe(LoginScreenContracts.View view) {
        mView = view;
    }

    @Override
    public void checkUserInDb(String email) {
        Disposable observable = Observable.create((ObservableOnSubscribe<User>) emitter ->{
            User user = mUserService.getUserByEmail(email);
            emitter.onNext(user);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background()).observeOn(mSchedulerProvider.ui())
                .subscribe(this::presentUserToView, error -> mView.showError(error)
                );
    }

    private void presentUserToView(User user) {
        //Constants.setCurrentUser(user);

        mView.startHomeScreen(user);

    }
}
