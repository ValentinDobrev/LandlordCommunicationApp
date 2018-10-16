package com.landlordcommunication.web.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int iD;

    @Column(name = "email")
    private String email;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    //to be defined via the LTR table
    private List<Residence> residences;

    // if true, user is a tenant, if false, user is a landlord - subject to redesign :)
    @Column(name = "isTenant")
    private boolean isTenant;

    @Column(name = "budget")
    private double budget;

    //to be populated with a query to the 'ratingRecords' table
    private double rating;


    public User() {
    }


    //autogenerated, could and most probably should be edited
    public User(int iD, String email, String firstName, String surname, List<Residence> residences, boolean isTenant, double budget, double rating) {
        this.iD = iD;
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
        this.residences = residences;
        this.isTenant = isTenant;
        this.budget = budget;
        this.rating = rating;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Residence> getResidences() {
        return residences;
    }

    public void setResidences(List<Residence> residences) {
        this.residences = residences;
    }

    public boolean getIsTenant() {
        return isTenant;
    }

    public void setIsTenant(boolean isTenant) {
        this.isTenant = isTenant;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
