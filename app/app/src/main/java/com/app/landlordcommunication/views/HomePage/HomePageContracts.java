package com.app.landlordcommunication.views.HomePage;

import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;

import java.util.List;


public interface HomePageContracts {

    interface View{

        void setPresenter(Presenter presenter);

        void showResidences();

        void showEmptyList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showResidenceOverview(Residence residence);

        void addResidences(List<Residence> movies);

        void showUser(User user);

    }

    interface Presenter{

        void subscribe(View view);

        void loadResidences();

        void selectResidence(Residence residence);

        void loadUser();

    }


}
