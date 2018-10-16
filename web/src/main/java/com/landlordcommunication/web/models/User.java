package com.landlordcommunication.web.models;

import java.util.List;

public class User {

    private int iD;

    private String email;

    private String firstName;

    private String surname;

    private List<Residence> residences;

    // if false, user is a landlord - subject to redesign :)
    private boolean isTenant;

    private double budget;

    //to be populated with a query to the 'ratingRecords' table
    private double rating;


}
