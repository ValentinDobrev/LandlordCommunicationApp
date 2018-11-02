package com.app.landlordcommunication.views.LoginScreen;

import com.app.landlordcommunication.async.base.SchedulerProvider;
import com.app.landlordcommunication.models.AuthorisationInfo;
import com.app.landlordcommunication.models.LoginInfo;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.services.user.base.UserService;

import java.io.IOException;

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
    public void checkUserInDb(LoginInfo loginInfo) {

        Disposable observable = Observable.create((ObservableOnSubscribe<AuthorisationInfo>) emitter ->{
            AuthorisationInfo authorisationInfo = mUserService.getUserByEmail(loginInfo);
            emitter.onNext(authorisationInfo);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background()).observeOn(mSchedulerProvider.ui())
                .subscribe(this::presentUserToView, error -> mView.showError(error)
                );

    }

    private void presentUserToView(AuthorisationInfo authorisationInfo) throws IOException {

        //TODO add this user to state somehow

        if(authorisationInfo.getIsTenant()){
            mView.startTenantHomeScreen();
        }

        if(!authorisationInfo.getIsTenant()){

            mView.startHomeScreen();

        }



    }
}
