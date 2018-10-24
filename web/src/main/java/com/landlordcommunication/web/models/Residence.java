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

    @ManyToMany(mappedBy = "residences", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<User> users = new ArrayList<>();

    public Residence() {
    }

    public Residence(int residenceId, String address, double rent, Date dueDate, Date notificationDate) {
        setResidenceId(residenceId);
        setAddress(address);
        setRent(rent);
        setDueDate(dueDate);
        setNotificationDate(notificationDate);
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Message> messages = new ArrayList<>();

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getResidenceId() {
        return residenceId;
    }

    private void setResidenceId(int residenceId) {
        this.residenceId = residenceId;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public double getRent() {
        return rent;
    }

    private void setRent(double rent) {
        this.rent = rent;
    }

    public List<User> getUsers() {
        return users;
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
}
