package com.app.landlordcommunication.views.users_list;

import com.app.landlordcommunication.async.base.SchedulerProvider;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.services.user.base.UserService;

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
    public UsersListPresenter(UserService userService, SchedulerProvider schedulerProvider) {
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
            emitter.onNext(users);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(error -> mView.showError(error))
                .doFinally(mView::hideLoading)
                .subscribe(this::presentUsersToView);
    }

    @Override
    public void filterUsers(String pattern) {
        mView.showLoading();
        Disposable observable = Observable.create((ObservableOnSubscribe<List<User>>) emitter -> {
            List<User> users = mUserService.getFilteredUsers(pattern);
            emitter.onNext(users);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(error -> mView.showError(error))
                .doFinally(mView::hideLoading)
                .subscribe(this::presentUsersToView);
    }

    private void presentUsersToView(List<User> users) {
        if(users.isEmpty()){
            mView.showEmptyList();
        }else{

            mView.showUsers(users);
        }
    }

    @Override
    public void selectUser(User user) {
        mView.showUserDetails(user);
    }
}
