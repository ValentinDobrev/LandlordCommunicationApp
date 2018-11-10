package com.app.landlordcommunication.services.message.base;

import com.app.landlordcommunication.models.Message;
import com.app.landlordcommunication.models.MessagesCounter;

import java.io.IOException;
import java.util.List;

public interface MessageService {
    Message sendMessage(Message message) throws IOException;
    void deleteMessage(int messageId) throws IOException;
    List<Message> getAllMessagesByReceiverIdAndByResidenceId(int receiverId, int residenceId) throws IOException;
    List<Message> getAllMessagesBetweenReceiverAndSender(int receiverId, int senderId) throws IOException;
    MessagesCounter getMessageCount(int receiverId, int senderId) throws IOException;
}
