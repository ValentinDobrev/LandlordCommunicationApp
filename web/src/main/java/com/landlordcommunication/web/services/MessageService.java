package com.landlordcommunication.web.services;

import com.landlordcommunication.web.models.Message;

import java.util.List;

public interface MessageService {

    void createMessage(Message message);
    void deleteMessage(int userId);
    List<Message> getAllMessagesByReceiverIdAndByResidenceId(int receiverId, int residenceId);

}
