package com.app.landlordcommunication.views.users_list;

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

        void selectUser(User user);

        void filterUsers(String pattern);

    }

    interface Navigator {
        void navigateWith(User user);
    }

}
