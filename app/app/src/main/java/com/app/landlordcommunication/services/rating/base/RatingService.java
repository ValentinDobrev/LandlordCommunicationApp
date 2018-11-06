package com.app.landlordcommunication.services.rating.base;

import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.models.UserRating;

import java.io.IOException;
import java.util.List;

public interface RatingService {
    UserRating getRatingByUserId(int id) throws IOException;
    List<UserRating> getAllRatings(List<User> users) throws IOException;
}
