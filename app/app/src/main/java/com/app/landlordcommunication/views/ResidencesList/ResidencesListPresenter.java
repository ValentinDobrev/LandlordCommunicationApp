package com.app.landlordcommunication.views.ResidencesList;

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

public class ResidencesListPresenter implements ResidencesListContracts.Presenter {

    private final ResidenceService mResidenceService;
    private final SchedulerProvider mSchedulerProvider;
    private ResidencesListContracts.View mView;
    private final  UserService mUserService;

    @Inject
    ResidencesListPresenter(ResidenceService mResidenceService, SchedulerProvider schedulerProvider, UserService mUserService) {
        this.mResidenceService = mResidenceService;
        this.mSchedulerProvider = schedulerProvider;
        this.mUserService = mUserService;
    }


    @Override
    public void subscribe(ResidencesListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadResidences() {

        mView.showLoading();
        Disposable observable = Observable.create((ObservableOnSubscribe<List<Residence>>) emitter -> {
            mView.showLoading();
            List<Residence> residences = mResidenceService.getResidencesByUser(Constants.CURRENT_USER_ID);
            emitter.onNext(residences);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(error -> mView.showError(error))
                .doFinally(mView::hideLoading)
                .subscribe(this::presentResidencesToView);
    }

    @Override
    public void loadUser() {
        mView.showLoading();
        Disposable observable = Observable.create((ObservableOnSubscribe<User>) emitter ->{
            User user = mUserService.getUserById(Constants.CURRENT_USER_ID);
            emitter.onNext(user);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(
                        this::presentUserToView,
                        error -> mView.showError(error)
                );
    }

    private void presentUserToView(User user) {
        mView.showUser(user);
    }


    private void presentResidencesToView(List<Residence> residences) {
        if (residences.isEmpty()) {
            mView.showEmptyList();
        } else {

            mView.showResidences(residences);
        }
    }

    @Override
    public void selectResidence(Residence residence) {
        mView.showResidenceOverview(residence);
    }
}
