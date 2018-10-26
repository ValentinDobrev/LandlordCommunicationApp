package com.landlordcommunication.web.controller;


import com.landlordcommunication.web.models.Message;
import com.landlordcommunication.web.services.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageRestController {

    private MessageService messageService;

    public MessageRestController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages/new")
    public void createMessage(@RequestBody Message message) {
        messageService.createMessage(message);
    }

    @DeleteMapping("/messages/delete/{id}")
    public void deleteMessage(@PathVariable int id) {
        messageService.deleteMessage(id);
    }

    @GetMapping("/for-receiver/{receiverId}/{residenceId}")
    public List<Message> getMessagesByReceiverAndResidence(@PathVariable int receiverId, @PathVariable int residenceId){
        return messageService.getAllMessagesByReceiverIdAndByResidenceId(receiverId, residenceId);
    }
}
