package com.app.landlordcommunication;

import com.app.landlordcommunication.models.Message;
import com.app.landlordcommunication.models.MessagesCounter;
import com.app.landlordcommunication.repositories.message.base.MessageRepository;
import com.app.landlordcommunication.services.message.HttpMessageService;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class HttpMessageServiceTests {

    @Mock
    MessageRepository mockMessageRepository;

    @InjectMocks
    HttpMessageService messageService;

    private static List<Message> mockMessageList;

    @BeforeClass
    public static void setUp(){

        mockMessageList = Arrays.asList(
                new Message(1,"text1",null, new Date(), 1, 2, 11),
                new Message(2,"text2",null, new Date(), 1, 2, 11),
                new Message(3,"text3",null, new Date(), 2, 1, 11),
                new Message(4,"text4",null, new Date(), 2, 1, 11),
                new Message(5,"text5",null, new Date(), 1, 2, 11)
        );

    }

    @Test
    public void createMessage_UploadMessageToDbAndReturnIt() throws IOException {
        //Arrange
        Message messageToCreate = new Message(6, "text6", null, new Date(), 2, 1, 11);
        Mockito.when(mockMessageRepository.sendMessage(messageToCreate))
                .thenReturn(messageToCreate);

        //Act
        Message result = messageService.sendMessage(messageToCreate);

        //Assert
        Assert.assertEquals(result,messageToCreate);


    }

    @Test
    public void getMessageCount_getCountOfMessagesBetweenSenderAndReceiver() throws IOException {
        //Arrange
        MessagesCounter messagesCounter = new MessagesCounter(mockMessageList.size());

        Mockito.when(mockMessageRepository.getMessageCount(2, 1))
                .thenReturn(messagesCounter);

        //Act
        MessagesCounter result = messageService.getMessageCount(2, 1);

        //Assert
        Assert.assertEquals(result.getCounter(), messagesCounter.getCounter());
    }

    @Test
    public void getAllMessagesByReceiverIdAndByResidenceId_GenerateFullListOfMessagesByReceiverAndResidence() throws IOException {
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
    public void getAllMessagesBetweenReceiverAndSender() throws IOException {
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
