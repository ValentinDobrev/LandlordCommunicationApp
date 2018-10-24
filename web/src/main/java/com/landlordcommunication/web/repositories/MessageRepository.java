package com.landlordcommunication.web.repositories;

import com.landlordcommunication.web.models.Message;

import java.util.List;

public interface MessageRepository {

    void createMessage(Message message);
    void deleteMessage(int userId);
    List<Message> getAllMessagesByReceiverIdAndByResidenceId(int receiverId, int residenceId);
}
