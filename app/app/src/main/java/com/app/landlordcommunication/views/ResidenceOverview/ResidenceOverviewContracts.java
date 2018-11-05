package com.app.landlordcommunication.views.ResidenceOverview;

import android.widget.Button;

import com.app.landlordcommunication.models.User;

import java.util.List;

public interface ResidenceOverviewContracts {
    interface View{

        void setPresenter(ResidenceOverviewContracts.Presenter presenter);

        void showUsers(List<User> users);

        void showEmptyList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showResidenceOverviewDetails();

        //void addUsers(List<User> users);

    }

    interface Presenter{

        void subscribe(ResidenceOverviewContracts.View view);

        void loadUsers();

        void selectUser(User user);

        void payRent();

        void selectPayBtn();
    }
}
