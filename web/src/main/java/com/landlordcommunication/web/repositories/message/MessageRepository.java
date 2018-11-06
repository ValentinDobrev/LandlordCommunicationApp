package com.landlordcommunication.web.repositories.message;

import com.landlordcommunication.web.models.Message;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface MessageRepository {
    void createMessage(Message message);
    void deleteMessage(int messageId);
    List<Message> getAllMessagesByReceiverIdAndByResidenceId(int receiverId, int residenceId);
    List<Message> getAllMessagesBetweenReceiverAndSender(int receiverId, int senderId);
    void deleteOldMessages(Date date);
}