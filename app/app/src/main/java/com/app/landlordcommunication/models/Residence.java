package com.app.landlordcommunication.models;

import android.graphics.Bitmap;

import java.util.Date;
import java.util.List;

public class Residence {

    private int residenceId;

    private String address;

    private double rent;

    private Date dueDate;

    private Date notificationDate;

    private List<User> users;

    private List<Message> messages;

    public Residence() {
    }

    public Residence(int residenceId, String address, double rent, Date dueDate, Date notificationDate) {
        setResidenceId(residenceId);
        setAddress(address);
        setRent(rent);
        setDueDate(dueDate);
        setNotificationDate(notificationDate);
    }


    public int getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(int residenceId) {
        this.residenceId = residenceId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}
