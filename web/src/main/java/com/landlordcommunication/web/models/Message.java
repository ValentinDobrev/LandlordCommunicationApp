package com.landlordcommunication.web.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")

public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int messageId;

    @Column(name = "text")
    private String text;

    @Column(name = "picture")
    private byte[] picture;

    @Column(name = "sent_date")
    private Date sentDate;

    @Column(name = "sender_id")
    private int senderId;

    @Column(name = "receiver_id")
    private int receiverId;

    @Column(name = "residence_id")
    private int residenceId;

    public Message(int messageId, String text, byte[] picture, Date sentDate, int senderId, int receiverId, int residenceId) {
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
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
