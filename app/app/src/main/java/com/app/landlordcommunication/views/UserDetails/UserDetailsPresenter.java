package com.app.landlordcommunication.views.UserDetails;

import com.app.landlordcommunication.async.base.SchedulerProvider;
import com.app.landlordcommunication.models.UserRating;
import com.app.landlordcommunication.services.rating.base.RatingService;
import com.app.landlordcommunication.services.user.base.UserService;
import com.app.landlordcommunication.models.User;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class UserDetailsPresenter implements UserDetailsContracts.Presenter {

    private final UserService mUserService;
    private final RatingService mRatingService;
    private final SchedulerProvider mSchedulerProvider;

    private UserDetailsContracts.View mView;
    private int mUserId;

    @Inject
    public UserDetailsPresenter (UserService service, RatingService ratingService, SchedulerProvider schedulerProvider) {
        mUserService = service;
        mRatingService = ratingService;
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
        .doFinally(mView::hideLoading)
        .subscribe(mView::showUser);
    }

    @Override
    public void loadUserRating() {
        mView.showLoading();
        Disposable observable = Observable.create((ObservableOnSubscribe<UserRating>) emitter -> {
            UserRating rating = mRatingService.getRatingByUserId(mUserId);
            emitter.onNext(rating);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(mView::showError)
                .doFinally(mView::hideLoading)
                .subscribe(mView::showRating);
    }

    @Override
    public void setUserId(int id) {
        mUserId = id;
    }
}
