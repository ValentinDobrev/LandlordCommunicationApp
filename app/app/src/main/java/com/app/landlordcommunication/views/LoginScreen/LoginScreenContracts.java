package com.app.landlordcommunication.views.LoginScreen;


import com.app.landlordcommunication.models.User;

public interface LoginScreenContracts {

    interface View{

        void setPresenter(LoginScreenContracts.Presenter presenter);

        void showError(Throwable e);

        void verifyUser(String email);


        void startHomeScreen(User user);
    }

    interface Presenter{

        void subscribe(LoginScreenContracts.View view);

        void checkUserInDb(String email);


    }

}
