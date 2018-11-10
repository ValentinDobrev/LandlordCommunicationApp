package com.app.landlordcommunication.views.UserDetails;

import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.models.UserRating;


public interface UserDetailsContracts {

    interface View {

        void showUser(User user);

        void showRating(UserRating rating);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void subscribe(View view);

        void loadUser();

        void loadUserRating();

        void updateUserRating(int ratingValue);

        boolean checkIfUserIsTheSame();

        void setUserId(int id);
    }
}
