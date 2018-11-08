package com.landlordcommunication.web.services.user;

import com.landlordcommunication.web.models.*;
import com.landlordcommunication.web.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Rating> getUserRating(int userId) {
        return repository.getUserRatings(userId);
    }

    @Override
    public UserRating getRatingById(int userId) {
        return repository.getRatingById(userId);
    }

    @Override
    public User getUserById(int userId) {
        return repository.getUserById(userId);
    }

    @Override
    public List<RentNotificationInfo> getRentNotificationInfo() {

        List<User> allUsers = getAllTenants();

        List<RentNotificationInfo> result = new ArrayList<>();

        for (User user : allUsers) {
//TODO implement a move adequate string identifier for notifications
            result.add(new RentNotificationInfo(user.getEmail().substring(0, 8), user.getResidences()));
        }
        return result;
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
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    @Override
    public List<User> getAllLandlords() {
        return repository.getAllLandlords();
    }

    @Override
    public List<User> getAllTenants() { return repository.getAllTenants();}

    @Override
    public List<User> getUsersByResidence(int residenceId) {
        return repository.getUsersByResidence(residenceId);
    }

    @Override
    public void payRentFromTenantToLandlord(int tenantId, int landlordId, int residenceId) {
        repository.payRentFromTenantToLandlord(tenantId, landlordId, residenceId);
    }

    @Override
    public AuthorisationInfo getUserByEmail(LoginInfo loginInfo) {
        User user = repository.getUserByEmail(loginInfo);
        if(user==null){
           return new AuthorisationInfo(-1, false,"No such username or password");
        }
        else if(!user.getPassword().equals(loginInfo.getPassword())){
            return new AuthorisationInfo(-1, false,"No such username or password");
        }
        return new AuthorisationInfo(user.getUserId(), user.getIsTenant(), user.getSurname());
    }
}
