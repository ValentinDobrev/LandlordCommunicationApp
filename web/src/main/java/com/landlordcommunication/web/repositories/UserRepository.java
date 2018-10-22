package com.landlordcommunication.web.repositories;

import com.landlordcommunication.web.models.User;

import java.util.List;

public interface UserRepository {
    void createUser(User user);
    void deleteUser(int userId);
    void modifyUser(int userId, User user);
    List<User> getTenantsByResidenceId(int residenceId);
    List<User> getLandlordsByResidenceId(int residenceId);
    List<User> getAllLandlords();
}
