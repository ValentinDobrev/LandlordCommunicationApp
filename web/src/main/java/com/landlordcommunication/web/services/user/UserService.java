package com.landlordcommunication.web.services.user;

import com.landlordcommunication.web.models.*;

import java.util.List;

public interface UserService {

    List<Rating> getUserRating(int userId);

    UserRating getRatingById(int userId);

    void createUser(User user);
    void deleteUser(int userId);
    void modifyUser(int userId, User user);
    List<User> getAllUsers();
    List<User> getAllLandlords();
    List<User> getUsersByResidence(int residenceId);
    void payRentFromTenantToLandlord(int tenantId, int landlordId, int residenceId);

    AuthorisationInfo getUserByEmail(LoginInfo email);
    User getUserById(int userId);
}
