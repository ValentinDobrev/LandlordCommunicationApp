package com.app.landlordcommunication.views.HomePage;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.async.base.SchedulerProvider;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.services.residence.base.ResidenceService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class HomePagePresenter implements HomePageContracts.Presenter {

    private final ResidenceService mResidenceService;
    private final SchedulerProvider mSchedulerProvider;
    private HomePageContracts.View mView;

    @Inject
    public HomePagePresenter(ResidenceService mResidenceService, SchedulerProvider schedulerProvider) {
        this.mResidenceService = mResidenceService;
        this.mSchedulerProvider = schedulerProvider;
    }


    @Override
    public void subscribe(HomePageContracts.View view) {
        mView = view;
    }

    @Override
    public void loadResidences() {

        mView.showLoading();
        Disposable observable = Observable.create((ObservableOnSubscribe<List<Residence>>) emitter ->{
            List<Residence> residences = mResidenceService.getResidencesByUser(Constants.CURRENT_USER_ID);
            emitter.onNext(residences);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background()).observeOn(mSchedulerProvider.ui()).doFinally(mView::hideLoading)
                .subscribe(this::presentResidencesToView, error -> mView.showError(error)
                );
    }

    private void presentResidencesToView(List<Residence> residences) {
        if(residences.isEmpty()){
            mView.showEmptyList();
        }else{

            mView.addResidences(residences);
        }
    }

    @Override
    public void selectResidence(Residence residence) {
        mView.showResidenceOverview(residence);
    }
}
