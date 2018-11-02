package com.landlordcommunication.web.models;

public class AuthorisationInfo {

    private int id;

    private boolean isTenant;

    public AuthorisationInfo() {
    }

    public AuthorisationInfo(int id, boolean isTenant) {
        this.id = id;
        this.isTenant = isTenant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsTenant() {
        return isTenant;
    }

    public void setIsTenant(boolean tenant) {
        isTenant = tenant;
    }
}
