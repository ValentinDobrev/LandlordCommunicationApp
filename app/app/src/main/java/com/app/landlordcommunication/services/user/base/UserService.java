package com.app.landlordcommunication.services.user.base;

import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    void createUser(User user) throws IOException;

    void modifyUser(int userId, User user) throws IOException;

    List<User> getAllLandlords() throws IOException;

    List<Rating> getUserRatings(int userId) throws IOException;

    List<User> getUsersByResidence(int residenceId) throws IOException;

    void payRentFromTenantToLandlord(int tenantId, int landlordId, int residenceId) throws IOException;
}
