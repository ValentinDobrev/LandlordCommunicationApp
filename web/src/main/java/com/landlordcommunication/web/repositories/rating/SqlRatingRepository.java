package com.landlordcommunication.web.repositories.rating;

import com.landlordcommunication.web.models.Rating;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SqlRatingRepository implements RatingRepository {

    private SessionFactory sessionFactory;

    @Autowired
    SqlRatingRepository(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public Rating addRatingRecord(Rating ratingRecord) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            if (ratingRecord.getRating() > 5) {
                ratingRecord.setRating(5);
            }
            if (ratingRecord.getRating() < 0) {
                ratingRecord.setRating(0);
            }
            session.save(ratingRecord);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return ratingRecord;
    }

    private void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
