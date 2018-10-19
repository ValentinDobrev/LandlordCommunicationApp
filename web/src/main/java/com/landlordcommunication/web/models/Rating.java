package com.landlordcommunication.web.models;

import javax.persistence.*;

@Entity
@Table(name = "ratingrecords")
public class Rating {

    @Column(name = "rating")
    private int rating;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int recordId;

    @Column(name = "giver_id")
    private int giverId;

    @Column(name = "taker_id")
    private int takerId;

    public Rating() {

    }

    public Rating(int rating, int recordId, int giverId, int takerId) {
        setRating(rating);
        setRecordId(recordId);
        setGiverId(giverId);
        setTakerId(takerId);
    }

    public int getRating() {
        return rating;
    }

    private void setRating(int rating) {
        this.rating = rating;
    }

    public int getRecordId() {
        return recordId;
    }

    private void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getGiverId() {
        return giverId;
    }

    private void setGiverId(int giverId) {
        this.giverId = giverId;
    }

    public int getTakerId() {
        return takerId;
    }

    private void setTakerId(int takerId) {
        this.takerId = takerId;
    }
}
