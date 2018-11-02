package com.app.landlordcommunication.views.LoginScreen;



public interface LoginScreenContracts {

    interface View{

        void setPresenter(LoginScreenContracts.Presenter presenter);

        void showError(Throwable e);

        void verifyUser(String email);


    }

    interface Presenter{

        void subscribe(LoginScreenContracts.View view);

        void checkUserInDb(String email);


    }

}
