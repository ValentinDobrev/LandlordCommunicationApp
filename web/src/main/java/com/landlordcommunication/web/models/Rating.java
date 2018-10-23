package com.landlordcommunication.web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "taker_id")
    private int takerId;

    @Column(name = "giver_id")
    private int giverId;

//    @ManyToOne()
//    @JoinColumn(name = "id", updatable = false, insertable = false)
//    private User taker;

    public Rating() {

    }

    public Rating(int recordId, int giverId, int takerId, int rating) {
        setRecordId(recordId);
        setGiverId(giverId);
        setTakerId(takerId);
        setRating(rating);
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

    public int getTakerId() {
        return takerId;
    }

    public void setTakerId(int takerId) {
        this.takerId = takerId;
    }

    public int getGiverId() {
        return giverId;
    }

    public void setGiverId(int giverId) {
        this.giverId = giverId;
    }

    //    public User getTaker() {
//        return taker;
//    }
//
//    public void setTaker(User taker) {
//        this.taker = taker;
//    }
}
