package com.app.landlordcommunication.views.HomePage;

import com.app.landlordcommunication.models.Residence;

import java.util.List;


public interface HomePageContracts {

    interface View{

        void setPresenter(Presenter presenter);

        void showResidences(List<Residence> residences);

        void showEmptyList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showResidenceOverview(Residence residence);

    }

    interface Presenter{

        void subscribe(View view);

        void loadResidences();

        void selectResidence(Residence residence);

    }


}
