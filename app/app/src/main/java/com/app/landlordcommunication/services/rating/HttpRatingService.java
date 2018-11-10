package com.app.landlordcommunication.services.rating;

import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.models.UserRating;
import com.app.landlordcommunication.repositories.rating.base.RatingRepository;
import com.app.landlordcommunication.services.rating.base.RatingService;

import java.io.IOException;
import java.util.List;

public class HttpRatingService implements RatingService {

    private final RatingRepository repository;

    public HttpRatingService(RatingRepository ratingRepository) {
        repository = ratingRepository;
    }

    @Override
    public UserRating getRatingByUserId(int id) throws IOException {
        return repository.getRatingByUserId(id);
    }

    @Override
    public List<UserRating> getAllRatings(List<User> users) throws IOException {
        return repository.getAllRatings(users);
    }

    @Override
    public Rating addRatingRecord(Rating ratingRecord) throws IOException {
        return repository.addRatingRecord(ratingRecord);
    }
}
