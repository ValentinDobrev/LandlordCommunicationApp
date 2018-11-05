package com.landlordcommunication.web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "residences")
public class Residence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int residenceId;

    @Column(name = "address")
    private String address;

    @Column(name = "rent")
    private double rent;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "notification_date")
    private Date notificationDate;

    @Column(name = "residence_picture")
    private String residencePicture;

    @ManyToMany(mappedBy = "residences", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<User> users = new ArrayList<>();

    public Residence() {
    }

    public Residence(int residenceId, String address, double rent, Date dueDate, Date notificationDate, String residencePicture) {
        setResidenceId(residenceId);
        setAddress(address);
        setRent(rent);
        setDueDate(dueDate);
        setNotificationDate(notificationDate);
        setResidencePicture(residencePicture);
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Message> messages = new ArrayList<>();

    // Setters


    public String getResidencePicture() {
        return residencePicture;
    }

    public void setResidencePicture(String residencePicture) {
        this.residencePicture = residencePicture;
    }

    public void setResidenceId(int residenceId) {
        this.residenceId = residenceId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    // Getters

    public int getResidenceId() {
        return residenceId;
    }

    public String getAddress() {
        return address;
    }

    public double getRent() {
        return rent;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
