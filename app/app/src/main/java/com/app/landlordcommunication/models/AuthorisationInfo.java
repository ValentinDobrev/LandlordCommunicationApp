package com.app.landlordcommunication.models;

public class AuthorisationInfo {

    private int id;

    private boolean isTenant;

    private String error;

    public AuthorisationInfo() {
    }

    public AuthorisationInfo(int id, boolean isTenant, String error) {
        this.id = id;
        this.isTenant = isTenant;
        this.error = error;
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

    public boolean isTenant() {
        return isTenant;
    }

    public void setTenant(boolean tenant) {
        isTenant = tenant;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
