package com.landlordcommunication.web.services;

import com.landlordcommunication.web.models.Rating;
import com.landlordcommunication.web.models.User;
import com.landlordcommunication.web.repositories.user.UserRepository;
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
    public List<Rating> getUserRating(int userId) {

        return repository.getUserRatings(userId);

//        double result = 0.0;
//
//        for (int i = 0; i < allRatings.size(); i++) {
//
//            result+= allRatings.get(i).getRating();
//
//        }
//
//        result = result / allRatings.size();
//
//        return result;

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
    public List<User> getAllLandlords() {
        return repository.getAllLandlords();
    }

    @Override
    public List<User> getUsersByResidence(int residenceId) {
        return repository.getUsersByResidence(residenceId);
    }
}
