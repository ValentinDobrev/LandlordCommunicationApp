package com.app.landlordcommunication.views.user_details;

import com.app.landlordcommunication.async.base.SchedulerProvider;
import com.app.landlordcommunication.services.user.base.UserService;
import com.app.landlordcommunication.models.User;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class UserDetailsPresenter implements UserDetailsContracts.Presenter {

    private final UserService mUserService;
    private final SchedulerProvider mSchedulerProvider;

    private UserDetailsContracts.View mView;
    private int mUserId;

    @Inject
    public UserDetailsPresenter (UserService service, SchedulerProvider schedulerProvider) {
        mUserService = service;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(UserDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadUser() {
        mView.showLoading();
        Disposable observable = Observable.create((ObservableOnSubscribe<User>) emitter -> {
            User user = mUserService.getUserById(mUserId);
            emitter.onNext(user);
            emitter.onComplete();
        })
        .subscribeOn(mSchedulerProvider.background())
        .observeOn(mSchedulerProvider.ui())
        .doOnError(mView::showError)
        .subscribe(mView::showUser);
    }

    @Override
    public void setUserId(int id) {
        mUserId = id;
    }
}
