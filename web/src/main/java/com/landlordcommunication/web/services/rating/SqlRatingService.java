package com.landlordcommunication.web.services.rating;

import com.landlordcommunication.web.models.Rating;
import com.landlordcommunication.web.repositories.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SqlRatingService implements RatingService {

    private RatingRepository repository;

    @Autowired
    SqlRatingService (RatingRepository repository) {
        setRepository(repository);
    }

    @Override
    public Rating addRatingRecord(Rating ratingRecord) {
        return repository.addRatingRecord(ratingRecord);
    }

    private void setRepository(RatingRepository repository) {
        this.repository = repository;
    }
}
