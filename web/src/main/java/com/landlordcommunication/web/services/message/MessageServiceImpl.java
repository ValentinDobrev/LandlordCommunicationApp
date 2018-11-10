package com.landlordcommunication.web.services.message;

import com.landlordcommunication.web.models.Message;
import com.landlordcommunication.web.models.MessagesCounter;
import com.landlordcommunication.web.models.User;
import com.landlordcommunication.web.notification_tools.MessageNotifier;
import com.landlordcommunication.web.repositories.message.MessageRepository;
import com.landlordcommunication.web.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository repository;

    private UserRepository userRepository;

    private MessageNotifier messageNotifier;

    @Autowired
    public MessageServiceImpl(MessageRepository repository, UserRepository userRepository, MessageNotifier messageNotifier) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.messageNotifier = messageNotifier;
    }

    @Override
    public Message createMessage(Message message) {

        User receiver = userRepository.getUserById(message.getReceiverId());
        User sender = userRepository.getUserById(message.getSenderId());

        messageNotifier.notifyReceiverOnNewMessageSent(
                receiver.getEmail().replace("@", "").replace(".", ""),
                sender.getFirstName() + " " + sender.getSurname());

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
