package com.landlordcommunication.web.schedulers;

import com.landlordcommunication.web.services.message.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MessageCleaningScheduler {
    private static final Logger logger = LoggerFactory.getLogger(MessageCleaningScheduler.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private MessageService messageService;

    @Autowired
    public MessageCleaningScheduler(MessageService messageService) {
        this.messageService = messageService;
    }

    public MessageCleaningScheduler() {
    }

    //cron expression below should be "0 * * * * ?" for every minute for testing
    // or "0 1 1 ? * *" for every day 1:01:am
    @Scheduled(cron = "0 1 1 ? * *")
    public void scheduleTaskWithCronExpression() {
        logger.info("Old messages deleted :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

        messageService.deleteOldMessages();
    }

}
