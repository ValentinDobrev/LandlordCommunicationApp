package com.app.landlordcommunication.views.MainMenu;

import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.models.User;

import java.util.List;

public interface MainMenuContracts {

    interface View {

        void setPresenter(Presenter presenter);

        void showUser(User user);

        void showUsers();

        void showHome(List<Residence> residences);

        void showLoginMenu();

    }

    interface Presenter {

        void subscribe(View view);

        void loadUser();

        void selectHome();

    }

}
