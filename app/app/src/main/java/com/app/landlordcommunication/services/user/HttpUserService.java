package com.app.landlordcommunication.services.user;

import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.repositories.user.base.UserRepository;
import com.app.landlordcommunication.services.user.base.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpUserService implements UserService {

    private final UserRepository repository;

    public HttpUserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(User user) throws IOException {
        repository.createUser(user);
    }

    @Override
    public void modifyUser(int userId, User user) throws IOException {
        repository.modifyUser(userId, user);
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        return repository.getAllUsers();
    }

    @Override
    public List<User> getAllLandlords() throws IOException {
        return repository.getAllLandlords();
    }

    @Override
    public List<Rating> getUserRatings(int userId) throws IOException {
        return repository.getUserRatings(userId);
    }

    @Override
    public List<User> getUsersByResidence(int residenceId) throws IOException {
        return repository.getUsersByResidence(residenceId);
    }

    @Override
    public List<User> getFilteredUsers(String pattern) throws IOException {
        String patternToLower = pattern.toLowerCase();

        List<User> users = new ArrayList<>();

        for (User u : getAllUsers()) {
            if (u.getFirstName().contains(patternToLower) || u.getSurname().contains(patternToLower)) {
                users.add(u);
            }
        }

        return users;
    }

    @Override
    public void payRentFromTenantToLandlord(int tenantId, int landlordId, int residenceId) throws IOException {
        repository.payRentFromTenantToLandlord(tenantId, landlordId, residenceId);
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.getUserByEmail(email);
    }
}
