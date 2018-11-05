package com.app.landlordcommunication.views.ResidenceOverview;

import android.widget.Button;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.async.base.SchedulerProvider;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.services.user.base.UserService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;


public class ResidenceOverviewPresenter implements ResidenceOverviewContracts.Presenter{

    private final UserService mUserService;
    private final SchedulerProvider mSchedulerProvider;
    private ResidenceOverviewContracts.View mView;

    @Inject
    public ResidenceOverviewPresenter(UserService mUserService, SchedulerProvider mSchedulerProvider) {
        this.mUserService = mUserService;
        this.mSchedulerProvider = mSchedulerProvider;
    }

    @Override
    public void subscribe(ResidenceOverviewContracts.View view) {
        mView = view;
    }

    @Override
    public void loadUsers() {
        mView.showLoading();
        Disposable observable = Observable.create((ObservableOnSubscribe<List<User>>) emitter ->{
            List<User> users = mUserService.getUsersByResidence(Constants.TEST_RESIDENCE_ID);
            //User user = mUserService.getUserById(Constants.TEST_RESIDENCE_ID);
            emitter.onNext(users);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(
                        this::presentUsersToView,
                        error -> mView.showError(error)
                );
    }

    @Override
    public void selectUser(User user) {
        mView.showResidenceOverviewDetails();
    }

    @Override
    public void payRent() {

    }

    @Override
    public void selectPayBtn() {
        mView.showResidenceOverviewDetails();
    }

    private void presentUsersToView(List<User> users) {
        if(users.isEmpty()){
            mView.showEmptyList();
        }else{

            mView.showUsers(users);
            //mView.addUsers(users);
        }
    }
}
