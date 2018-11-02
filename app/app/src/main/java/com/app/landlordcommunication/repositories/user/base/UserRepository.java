package com.app.landlordcommunication.repositories.user.base;

import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.User;

import java.io.IOException;
import java.util.List;

public interface UserRepository {

    User getUserbyId(int userId) throws IOException;

    void createUser(User user) throws IOException;

    void modifyUser(int userId, User user) throws IOException;

    List<User> getAllUsers() throws IOException;

    List<User> getAllLandlords() throws IOException;

    List<Rating> getUserRatings(int userId) throws IOException;

    List<User> getUsersByResidence(int residenceId) throws IOException;

    void payRentFromTenantToLandlord(int tenantId, int landlordId, int residenceId) throws IOException;

    User getUserByEmail(String email);
}
