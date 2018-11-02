package com.app.landlordcommunication;

import com.app.landlordcommunication.models.User;

public class Constants {
    //    public static final String BASE_SERVER_URL
    //       = "http://192.168.1.2:8080/api";

    //TODO clarify server url string in here and in repository classes
//    public static final String BASE_SERVER_URL
//            = "http://10.54.227.80:8080/api/residences";

    public static final String BASE_SERVER_URL
            = "http://10.54.227.80:8080/api";

//    public static final String BASE_SERVER_URL
//            = "http://192.168.0.101:8080/api";

    public static final int TEST_USER_ID = 19;
    public static  int TEST_RESIDENCE_ID = 21;
    ///       = "http://192.168.0.102:8080/api/users";
    //public static final int TEST_USER_ID = 18;

    public static final int USERS_LIST_IDENTIFIER = 7;

    public static final String USERS_EXTRA_STRING = "userName";

    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Constants.currentUser = currentUser;
    }


}
