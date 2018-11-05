package com.app.landlordcommunication.views.UsersList;

import com.app.landlordcommunication.models.User;

import java.util.List;

public interface UsersListContracts {

    interface View{

        void setPresenter(Presenter presenter);

        void showUsers(List<User> users);

        void showEmptyList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showUserDetails(User user);
    }

    interface Presenter{

        void subscribe(View view);

        void loadUsers();

        //void loadUserRatings():

        void selectUser(User user);

        void filterUsers(String pattern);

    }
}
