package com.landlordcommunication.web.controllers;


import com.landlordcommunication.web.models.Message;
import com.landlordcommunication.web.models.MessagesCounter;
import com.landlordcommunication.web.services.message.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageRestController {

    private MessageService messageService;

    public MessageRestController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return messageService.createMessage(message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable int id) {
        messageService.deleteMessage(id);
    }

    @GetMapping("/for-receiver/{receiverId}/{residenceId}")
    public List<Message> getMessagesByReceiverAndResidence(@PathVariable int receiverId, @PathVariable int residenceId){
        return messageService.getAllMessagesByReceiverIdAndByResidenceId(receiverId, residenceId);
    }

    @GetMapping("/for-receiver-by-sender/{receiverId}/{senderId}")
    public List<Message> getAllMessagesBetweenReceiverAndSender(@PathVariable int receiverId, @PathVariable int senderId){
        return messageService.getAllMessagesBetweenReceiverAndSender(receiverId, senderId);
    }

    @GetMapping("/count/{receiverId}/{senderId}")
    public MessagesCounter getMessagesCount(@PathVariable int receiverId, @PathVariable int senderId){
        return messageService.getMessageCount(receiverId, senderId);
    }
}
