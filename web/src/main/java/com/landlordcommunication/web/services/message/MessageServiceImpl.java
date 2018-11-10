package com.landlordcommunication.web.services.message;

import com.landlordcommunication.web.models.Message;
import com.landlordcommunication.web.models.MessagesCounter;
import com.landlordcommunication.web.repositories.message.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository repository;

    @Autowired
    public MessageServiceImpl(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Message createMessage(Message message) {
        return repository.createMessage(message);
    }

    @Override
    public MessagesCounter getMessageCount(int receiverId, int senderId) {
        List<Message> messages = repository.getAllMessagesBetweenReceiverAndSender(receiverId, senderId);
        MessagesCounter counter = new MessagesCounter();
        counter.setCounter(messages.size());
        return counter;
    }

    @Override
    public void deleteMessage(int messageId) {
        repository.deleteMessage(messageId);
    }

    @Override
    public List<Message> getAllMessagesByReceiverIdAndByResidenceId(int receiverId, int residenceId) {
        return repository.getAllMessagesByReceiverIdAndByResidenceId(receiverId, residenceId);
    }

    @Override
    public List<Message> getAllMessagesBetweenReceiverAndSender(int receiverId, int senderId) {
        List<Message>   result = repository.getAllMessagesBetweenReceiverAndSender(receiverId, senderId);
        result.addAll(repository.getAllMessagesBetweenReceiverAndSender(senderId, receiverId));
        result.sort(Comparator.comparing(Message::getMessageId));
        return result;

    }

    @Override
    public void deleteOldMessages() {
        //to delete messages older than three months per project specifications
        repository.deleteOldMessages(Date.from(ZonedDateTime.now().minusMonths(3).toInstant()));
    }
}
