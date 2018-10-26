package com.landlordcommunication.web.repositories;

import com.landlordcommunication.web.models.Message;

import java.util.List;

public interface MessageRepository {
    void createMessage(Message message);
    void deleteMessage(int messageId);
    List<Message> getAllMessagesByReceiverIdAndByResidenceId(int receiverId, int residenceId);
    List<Message> getAllMessagesBetweenReceiverAndSender(int receiverId, int senderId);
}