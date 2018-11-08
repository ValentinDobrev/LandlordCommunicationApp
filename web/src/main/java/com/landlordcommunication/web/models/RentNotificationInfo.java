package com.landlordcommunication.web.models;

import java.util.List;

public class RentNotificationInfo {

    private String userEmail;

    private List<Residence> residences;

    public RentNotificationInfo() {
    }

    public RentNotificationInfo(String userEmail, List<Residence> residences) {
        setUserEmail(userEmail);
        setResidences(residences);
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Residence> getResidences() {
        return residences;
    }

    public void setResidences(List<Residence> residences) {
        this.residences = residences;
    }
}
