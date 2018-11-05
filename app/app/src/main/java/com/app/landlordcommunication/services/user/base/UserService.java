package com.app.landlordcommunication.services.user.base;

import android.util.Log;

import com.app.landlordcommunication.models.AuthorisationInfo;
import com.app.landlordcommunication.models.LoginInfo;
import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    User getUserById(int userId) throws IOException;

    void createUser(User user) throws IOException;

    void modifyUser(int userId, User user) throws IOException;

    List<User> getAllUsers() throws IOException;

    List<User> getAllLandlords() throws IOException;

    List<User> getUsersByResidence(int residenceId) throws IOException;

    List<User> getFilteredUsers(String pattern) throws IOException;

    List<Rating> getUserRatings(int userId) throws IOException;

    void payRentFromTenantToLandlord(int tenantId, int landlordId, int residenceId) throws IOException;

    AuthorisationInfo getUserByEmail(LoginInfo loginInfo);
}
