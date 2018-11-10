package com.app.landlordcommunication.repositories.rating.base;

import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.models.UserRating;

import java.io.IOException;
import java.util.List;

public interface RatingRepository {
    UserRating getRatingByUserId(int id) throws IOException;
    List<UserRating> getAllRatings(List<User> users) throws IOException;
    Rating addRatingRecord(Rating ratingRecord) throws IOException;
}
