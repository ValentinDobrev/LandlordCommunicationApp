package com.landlordcommunication.web.services.user;

import com.landlordcommunication.web.models.Rating;
import com.landlordcommunication.web.models.Residence;
import com.landlordcommunication.web.models.User;

import java.util.List;

public interface UserService {

    List<Rating> getUserRating(int userId);

    void createUser(User user);
    void deleteUser(int userId);
    void modifyUser(int userId, User user);
    List<User> getAllLandlords();
    List<User> getUsersByResidence(int residenceId);
    void payRentFromTenantToLandlord(int tenantId, int landlordId, int residenceId);
    User getUserById(int userId);
}
