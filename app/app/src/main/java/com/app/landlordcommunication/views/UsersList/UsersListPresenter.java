package com.app.landlordcommunication.views.UsersList;

import com.app.landlordcommunication.async.base.SchedulerProvider;
import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.models.UserRating;
import com.app.landlordcommunication.services.rating.base.RatingService;
import com.app.landlordcommunication.services.user.base.UserService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class UsersListPresenter implements UsersListContracts.Presenter {

    private final UserService mUserService;
    private final SchedulerProvider mSchedulerProvider;
    private UsersListContracts.View mView;

    @Inject
    UsersListPresenter(UserService userService, SchedulerProvider schedulerProvider) {
        mUserService = userService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(UsersListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadUsers() {
        mView.showLoading();
        Disposable observable = Observable.create((ObservableOnSubscribe<List<User>>) emitter -> {
            List<User> users = mUserService.getAllUsers();
            for (User user : users) {
                List<Rating> userRatings = mUserService.getUserRatings(user.getUserId());

                user.setRatingsTaken(userRatings);
            }
            emitter.onNext(users);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(error -> mView.showError(error))
                .doFinally(mView::hideLoading)
                .subscribe(this::presentUsersToView);
    }

    private void presentUsersToView(List<User> users) {
        if (users.isEmpty()) {
            mView.showEmptyList();
        } else {

            mView.showUsers(users);
        }
    }

    @Override
    public void selectUser(User user) {
        mView.showUserDetails(user);
    }
}
