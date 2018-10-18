package com.landlordcommunication.web.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usertoresidence")
public class UserToResidence {

    @Column(name = "IdTenant")
    private int tenantId;

    @Column(name = "IdLandlord")
    private int landlordId;

    @Column(name = "IdResidence")
    private int residenceId;

    public UserToResidence() {

    }

    public UserToResidence(int tenantId, int landlordId, int residenceId) {
        setTenantId(tenantId);
        setLandlordId(landlordId);
        setResidenceId(residenceId);
    }

    public int getTenantId() {
        return tenantId;
    }

    private void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public int getLandlordId() {
        return landlordId;
    }

    private void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }

    public int getResidenceId() {
        return residenceId;
    }

    private void setResidenceId(int residenceId) {
        this.residenceId = residenceId;
    }
}
