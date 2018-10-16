package com.landlordcommunication.web.models;

import java.util.List;

public class Residence {

    private int id;

    private String address;

    private int landlordId;

    private double rent;

    /*private <Something> image/image gallery;

   TODO figure how to store images - with URLs or binary objects

    */

    //to be populated via a SELECT query that uses join to gather info from 'users', 'LTR'
    private List<Integer> tenantIds;



}
