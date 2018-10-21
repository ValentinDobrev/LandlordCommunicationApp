package com.landlordcommunication.web.services;

import com.landlordcommunication.web.models.User;

import java.util.List;

public interface UserService {

    double getUserRating(int userId);

    void createUser(User user);
    void deleteUser(int userId);
    void modifyUser(int userId, User user);
    List<User> getTenantsByResidence();
    List<User> getLandlordsByResidence();
    List<User> getAllLandlords();
}
