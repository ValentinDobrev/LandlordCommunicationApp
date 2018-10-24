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

    // Setters
    private void setResidenceId(int residenceId) {
        this.residenceId = residenceId;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    private void setRent(double rent) {
        this.rent = rent;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    // Getters
    public List<User> getUsers() {
        return users;
    }
}
