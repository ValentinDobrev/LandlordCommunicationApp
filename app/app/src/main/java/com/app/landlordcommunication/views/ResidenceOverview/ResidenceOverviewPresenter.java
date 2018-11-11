package com.app.landlordcommunication.views.ResidenceOverview;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.async.base.SchedulerProvider;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.services.residence.base.ResidenceService;
import com.app.landlordcommunication.services.user.base.UserService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;


public class ResidenceOverviewPresenter implements ResidenceOverviewContracts.Presenter{

    private final UserService mUserService;
    private final ResidenceService mResidenceService;
    private final SchedulerProvider mSchedulerProvider;
    private ResidenceOverviewContracts.View mView;

    @Inject
    public ResidenceOverviewPresenter(UserService mUserService, ResidenceService mResidenceService, SchedulerProvider mSchedulerProvider) {
        this.mUserService = mUserService;
        this.mResidenceService = mResidenceService;
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
    public void loadResidence(int residenceId) {
        mView.showLoading();
        Disposable observable = Observable.create((ObservableOnSubscribe<Residence>) emitter -> {
            Residence residence = mResidenceService.getResidenceById(residenceId);
            emitter.onNext(residence);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(error -> mView.showError(error))
                .doFinally(mView::hideLoading)
                .subscribe(mView::showLoadedResidence);
    }

    @Override
    public void loadCorrectDates() {
        Disposable observable = Observable.create((ObservableOnSubscribe<Residence>) emitter ->{
            Residence residence = mResidenceService.changeResidenceDates(Constants.TEST_RESIDENCE_ID);
            emitter.onNext(residence);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(
                        this::presentResidenceToView
                );
    }

    private void presentResidenceToView(Residence residence) {
        mView.showResidence(residence);
    }

    @Override
    public void selectUser(User user) {
        mView.showChatScreen(user);
    }

    @Override
    public void payRent() {

    }

    @Override
    public void selectPayBtn() {
//        loadCorrectDates();
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
