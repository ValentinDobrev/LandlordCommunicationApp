package com.app.landlordcommunication.views.user_details;

import com.app.landlordcommunication.models.User;

public interface UserDetailsContracts {

    interface View {
        void showUser(User user);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void subscribe(View view);

        void loadUser();

        void setUserId(int id);
    }
}
