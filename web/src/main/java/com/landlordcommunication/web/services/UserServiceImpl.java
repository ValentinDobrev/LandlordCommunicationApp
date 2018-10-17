package com.landlordcommunication.web.services;

import com.landlordcommunication.web.models.User;
import com.landlordcommunication.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(User user) {
        repository.createUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        repository.deleteUser(userId);
    }

    @Override
    public void modifyUser(int userId, User user) {
        repository.modifyUser(userId, user);
    }

    @Override
    public List<User> getTenantsByResidence() {
        return null;
    }

    @Override
    public List<User> getLandlordsByResidence() {
        return null;
    }

    @Override
    public List<User> getAllLandlords() {
        return null;
    }
}
