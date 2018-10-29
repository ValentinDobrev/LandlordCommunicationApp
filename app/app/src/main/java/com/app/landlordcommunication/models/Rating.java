package com.app.landlordcommunication.models;

public class Rating {

    private int rating;

    private int recordId;

    private int takerId;

    private int giverId;

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

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
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
}
