package com.landlordcommunication.web.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUser")
    private int idUser;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Email")
    private String email;

    @Column(name = "Budget")
    private double budget;

    // if true, user is a tenant, if false, user is a landlord - subject to redesign :)
    @Column(name = "IsTenant")
    private boolean isTenant;

    //to be defined via the LTR table
    //private List<Residence> residences;

    //to be populated with a query to the 'ratingRecords' table
    //private double rating;


    public User() {
    }


    //autogenerated, could and most probably should be edited
    public User(int iD, String email, String firstName, String surname, List<Residence> residences, boolean isTenant, double budget/*, double rating*/) {
        this.idUser = iD;
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
       // this.residences = residences;
        this.isTenant = isTenant;
        this.budget = budget;
        //this.rating = rating;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    /*public List<Residence> getResidences() {
        return residences;
    }

    public void setResidences(List<Residence> residences) {
        this.residences = residences;
    }*/

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

    /*public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }*/
}
