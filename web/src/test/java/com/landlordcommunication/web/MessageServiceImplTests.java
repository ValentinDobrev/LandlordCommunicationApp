package com.landlordcommunication.web;

import com.landlordcommunication.web.models.Message;
import com.landlordcommunication.web.models.MessagesCounter;
import com.landlordcommunication.web.repositories.message.MessageRepository;
import com.landlordcommunication.web.services.message.MessageServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceImplTests {

    @Mock
    MessageRepository mockMessageRepository;

    @InjectMocks
    MessageServiceImpl messageService;

    private List<Message> mockMessageList;

    @Before
    public void setUp(){

        /*"messageId": 1,
                "text": "hi",
                "picture": null,
                "sentDate": "2018-11-01T11:27:30.000+0000",
                "senderId": 13,
                "receiverId": 23,
                "residenceId": 25*/



        mockMessageList = Arrays.asList(
                new Message(1,"text1",null, new Date(), 1, 2, 11),
                new Message(2,"text2",null, new Date(), 1, 2, 11),
                new Message(3,"text3",null, new Date(), 2, 1, 11),
                new Message(4,"text4",null, new Date(), 2, 1, 11),
                new Message(5,"text5",null, new Date(), 1, 2, 11)
        );
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createMessage_UploadMessageToDbAndReturnIt(){
        //Arrange
        Message messageToCreate = new Message(6, "text6", null, new Date(), 2, 1, 11);
        Mockito.when(mockMessageRepository.createMessage(messageToCreate))
                .thenReturn(messageToCreate);

        //Act
        Message result = messageService.createMessage(messageToCreate);

        //Assert
        Assert.assertEquals(result,messageToCreate);


    }

    @Test
    public void getMessageCount_getCountOfMessagesBetweenSenderAndReceiver(){
        //Arrange
        MessagesCounter messagesCounter = new MessagesCounter(mockMessageList.size());

        Mockito.when(mockMessageRepository.getAllMessagesBetweenReceiverAndSender(2, 1))
                .thenReturn(mockMessageList);

        //Act
        MessagesCounter result = messageService.getMessageCount(2, 1);

        //Assert
        Assert.assertEquals(result.getCounter(), messagesCounter.getCounter());
    }

    @Test
    public void getAllMessagesByReceiverIdAndByResidenceId_GenerateFullListOfMessagesByReceiverAndResidence(){
        //Arrange
        List<Message> messageListReceivedId2 = Arrays.asList(
                mockMessageList.get(0),
                mockMessageList.get(1),
                mockMessageList.get(4));

        Mockito.when(mockMessageRepository.getAllMessagesByReceiverIdAndByResidenceId(2,11))
                .thenReturn(messageListReceivedId2);

        //Act
        List<Message> result = messageService.getAllMessagesByReceiverIdAndByResidenceId(2, 11);

        //Assert
        Assert.assertEquals(result, messageListReceivedId2);

    }

    @Test
    public void getAllMessagesBetweenReceiverAndSender(){
        //Arrange
        List<Message> sortedMessageList = new ArrayList<>(mockMessageList);
        sortedMessageList.sort(Comparator.comparing(Message::getMessageId));
        Mockito.when(mockMessageRepository.getAllMessagesBetweenReceiverAndSender(2,1))
        .thenReturn(sortedMessageList);

        //Act
        List<Message> result = messageService.getAllMessagesBetweenReceiverAndSender(2, 1);

        //Assert
        Assert.assertEquals(result, sortedMessageList);

    }
}
