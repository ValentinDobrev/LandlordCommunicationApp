package com.app.landlordcommunication.models;

import java.util.List;

public class User {

    private int userId;

    private String firstName;

    private String surname;

    private String email;

    private String password;

    private double budget;

    // if true, user is a tenant, if false, user is a landlord - subject to redesign :)
    private boolean isTenant;

    private List<Residence> residences;

    private List<Rating> ratingsTaken;

    private List<Message> messages;

    public User() {
    }

    public User(int id, String email, String firstName, String surname, boolean isTenant, double budget, String password) {
        setUserId(id);
        setEmail(email);
        setFirstName(firstName);
        setSurname(surname);
        setIsTenant(isTenant);
        setBudget(budget);
        setPassword(password);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public boolean getIsTenant() {
        return isTenant;
    }

    public void setIsTenant(boolean tenant) {
        isTenant = tenant;
    }

    public List<Residence> getResidences() {
        return residences;
    }

    public void setResidences(List<Residence> residences) {
        this.residences = residences;
    }

    public List<Rating> getRatingsTaken() {
        return ratingsTaken;
    }

    public void setRatingsTaken(List<Rating> ratingsTaken) {
        this.ratingsTaken = ratingsTaken;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
