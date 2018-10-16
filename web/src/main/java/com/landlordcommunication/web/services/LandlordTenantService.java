package com.landlordcommunication.web.services;

import com.landlordcommunication.web.models.User;

import java.util.List;

public interface LandlordTenantService {
    List<User> getAll();
    User getById(int id);
    void create(User user);
    void update(int id, User user);
    void delete(int id);
}
