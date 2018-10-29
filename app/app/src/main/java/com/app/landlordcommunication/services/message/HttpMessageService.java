package com.app.landlordcommunication.services.message;

import com.app.landlordcommunication.models.Message;
import com.app.landlordcommunication.repositories.message.base.MessageRepository;
import com.app.landlordcommunication.services.message.base.MessageService;

import java.io.IOException;
import java.util.List;

public class HttpMessageService implements MessageService {

    private final MessageRepository repository;

    public HttpMessageService(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Message sendMessage(Message message) throws IOException {
        return repository.sendMessage(message);
    }

    @Override
    public void deleteMessage(int messageId) throws IOException {
        repository.deleteMessage(messageId);
    }

    @Override
    public List<Message> getAllMessagesByReceiverIdAndByResidenceId(int receiverId, int residenceId) throws IOException {
        return repository.getAllMessagesByReceiverIdAndByResidenceId(receiverId, residenceId);
    }

    @Override
    public List<Message> getAllMessagesBetweenReceiverAndSender(int receiverId, int senderId) throws IOException {
        return repository.getAllMessagesBetweenReceiverAndSender(receiverId, senderId);
    }
}
