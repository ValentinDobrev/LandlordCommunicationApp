package com.app.landlordcommunication.models;

import java.io.Serializable;

public class UserRating implements Serializable {

    private int userId;
    private double rating;

    public UserRating() {

    }

    public UserRating (int userId, double rating) {
        setUserId(userId);
        setRating(rating);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

}
