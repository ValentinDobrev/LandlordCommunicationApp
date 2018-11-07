package com.app.landlordcommunication.views.MainMenu;

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

public class MainMenuPresenter implements MainMenuContracts.Presenter {

    private final UserService mUserService;
    private final ResidenceService mResidenceService;
    private final SchedulerProvider mSchedulerProvider;

    private MainMenuContracts.View mView;

    @Inject
    MainMenuPresenter(UserService userService, ResidenceService residenceService, SchedulerProvider provider) {
        mUserService = userService;
        mResidenceService = residenceService;
        mSchedulerProvider = provider;
    }

    @Override
    public void subscribe(MainMenuContracts.View view) {
        mView = view;
    }

    @Override
    public void loadUser() {
        Disposable observable = Observable.create((ObservableOnSubscribe<User>) emitter -> {
            User user = mUserService.getUserById(Constants.CURRENT_USER_ID);
            emitter.onNext(user);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(mView::showUser);
    }

    @Override
    public void selectHome() {
        Disposable observable = Observable.create((ObservableOnSubscribe<List<Residence>>) emitter -> {
            List<Residence> residences = mResidenceService.getResidencesByUser(Constants.CURRENT_USER_ID);
            emitter.onNext(residences);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(mView::showHome);
    }
}
