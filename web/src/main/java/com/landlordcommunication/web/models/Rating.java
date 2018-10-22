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

    /*@ManyToOne
    @JoinColumn(name = "id")
    private User giver;
*/
    @ManyToOne
    @JoinColumn(name = "userId")
    private User taker;

    public Rating() {

    }

    public Rating(int rating, int recordId, User taker/*User giver*/) {
        setRating(rating);
        setRecordId(recordId);
       // setGiver(giver);
        setTaker(taker);
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


    public User getTaker() {
        return taker;
    }

    public void setTaker(User taker) {
        this.taker = taker;
    }
}
