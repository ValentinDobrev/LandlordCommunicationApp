package com.landlordcommunication.web.services;

import com.landlordcommunication.web.models.Message;
import com.landlordcommunication.web.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository repository;

    @Autowired
    public MessageServiceImpl(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createMessage(Message message) {
        repository.createMessage(message);
    }

    @Override
    public void deleteMessage(int messageId) {
        repository.deleteMessage(messageId);
    }

    @Override
    public List<Message> getAllMessagesByReceiverIdAndByResidenceId(int receiverId, int residenceId) {
        return repository.getAllMessagesByReceiverIdAndByResidenceId(receiverId, residenceId);
    }
}
