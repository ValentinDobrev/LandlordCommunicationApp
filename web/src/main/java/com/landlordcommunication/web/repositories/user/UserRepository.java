package com.landlordcommunication.web.repositories.user;

import com.landlordcommunication.web.models.Rating;
import com.landlordcommunication.web.models.User;

import java.util.List;

public interface UserRepository {
    void createUser(User user);
    void deleteUser(int userId);
    void modifyUser(int userId, User user);
    List<User> getAllLandlords();
    List<Rating> getUserRatings(int userId);
    List<User> getUsersByResidence(int residenceId);
    void payRentFromTenantToLandlord(int tenantId, int landlordId, int residenceId);
    User getUserById(int userId);
}
