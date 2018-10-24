package com.landlordcommunication.web.services;

import com.landlordcommunication.web.models.Message;
import com.landlordcommunication.web.repositories.MessageRepository;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    private MessageRepository repository;

    @Override
    public void createMessage(Message message) {
        repository.createMessage(message);
    }

    @Override
    public void deleteMessage(int userId) {
        repository.deleteMessage(userId);
    }

    @Override
    public List<Message> getAllMessagesByReceiverIdAndByResidenceId(int receiverId, int residenceId) {
        return repository.getAllMessagesByReceiverIdAndByResidenceId(receiverId, residenceId);
    }
}
