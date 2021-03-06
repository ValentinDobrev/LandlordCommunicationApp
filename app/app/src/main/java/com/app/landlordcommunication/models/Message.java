package com.app.landlordcommunication.models;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private int messageId;

    private String text;

    private String picture;

    private Date sentDate;

    private int senderId;

    private int receiverId;

    private int residenceId;

    public Message() {

    }

    public Message(int messageId, String text, String picture, Date sentDate, int senderId, int receiverId, int residenceId) {
        setMessageId(messageId);
        setText(text);
        setPicture(picture);
        setSentDate(sentDate);
        setSenderId(senderId);
        setReceiverId(receiverId);
        setResidenceId(residenceId);
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(int residenceId) {
        this.residenceId = residenceId;
    }
}
