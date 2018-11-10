package com.landlordcommunication.web.services.message;

import com.landlordcommunication.web.models.Message;
import com.landlordcommunication.web.models.MessagesCounter;

import java.util.Date;
import java.util.List;

public interface MessageService {
    Message createMessage(Message message);
    void deleteMessage(int messageId);
    List<Message> getAllMessagesByReceiverIdAndByResidenceId(int receiverId, int residenceId);
    List<Message> getAllMessagesBetweenReceiverAndSender(int receiverId, int senderId);
    void deleteOldMessages();
    MessagesCounter getMessageCount(int receiverId, int senderId);
}
