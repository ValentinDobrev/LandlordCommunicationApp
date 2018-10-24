package com.landlordcommunication.web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ratingrecords")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int recordId;

    @Column(name = "giver_id")
    private int giverId;

    @Column(name = "taker_id")
    private int takerId;

    @Column(name = "rating")
    private int rating;

    public Rating() {

    }

    public Rating(int recordId, int giverId, int takerId, int rating) {
        setRecordId(recordId);
        setGiverId(giverId);
        setTakerId(takerId);
        setRating(rating);
    }

    // Setters
    private void setRating(int rating) {
        this.rating = rating;
    }

    private void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public void setTakerId(int takerId) {
        this.takerId = takerId;
    }

    public void setGiverId(int giverId) {
        this.giverId = giverId;
    }

    // Getters
}
