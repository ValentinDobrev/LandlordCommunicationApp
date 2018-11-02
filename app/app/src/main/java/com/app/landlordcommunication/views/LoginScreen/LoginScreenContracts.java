package com.app.landlordcommunication.views.LoginScreen;


import com.app.landlordcommunication.models.LoginInfo;


public interface LoginScreenContracts {

    interface View{

        void setPresenter(LoginScreenContracts.Presenter presenter);

        void showError(Throwable e);

        void verifyUser(LoginInfo loginInfo);

        void startHomeScreen();

        void startTenantHomeScreen();
    }

    interface Presenter{

        void subscribe(LoginScreenContracts.View view);

        void checkUserInDb(LoginInfo loginInfo);


    }

}
