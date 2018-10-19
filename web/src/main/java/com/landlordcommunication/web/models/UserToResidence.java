package com.landlordcommunication.web.models;

import javax.persistence.*;

@Entity
@Table(name = "usertoresidence")
public class UserToResidence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int relationId;

    @Column(name = "residence_id")
    private int residenceId;

    @Column(name = "user_id")
    private int userId;

    public UserToResidence() {
    }

    public UserToResidence(int relationId, int residenceId, int userId) {
        setRelationId(relationId);
        setResidenceId(residenceId);
        setUserId(userId);
    }

    public int getRelationId() {
        return relationId;
    }

    public void setRelationId(int relationId) {
        this.relationId = relationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getResidenceId() {
        return residenceId;
    }

    private void setResidenceId(int residenceId) {
        this.residenceId = residenceId;
    }
}
