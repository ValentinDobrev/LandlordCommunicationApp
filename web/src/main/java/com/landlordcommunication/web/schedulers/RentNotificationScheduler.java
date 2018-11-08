package com.landlordcommunication.web.schedulers;

import com.landlordcommunication.web.models.RentNotificationInfo;
import com.landlordcommunication.web.models.Residence;
import com.landlordcommunication.web.notification_tools.RentNotifier;
import com.landlordcommunication.web.services.message.MessageService;
import com.landlordcommunication.web.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class RentNotificationScheduler {
    private static final Logger logger = LoggerFactory.getLogger(MessageCleaningScheduler.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Autowired
    UserService userService;

    @Autowired
    RentNotifier rentNotifier;

    //cron expression below should be "0 * * * * ?" for every minute
    // or "0 1 1 ? * *" for every day 1:01:am
    @Scheduled(cron = "0 * * * * ?")
    public void scheduleTaskWithCronExpression() {
        logger.info("Rent notifications checked and sent :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
//TODO figure out how to compare dates
        System.out.println( Date.from(ZonedDateTime.now().plusDays(5).toInstant()));

        for (RentNotificationInfo infobox : userService.getRentNotificationInfo()) {
            for (Residence residence : infobox.getResidences()){
                //to notify tenants 5 days prior to the rent's due date per project specifications
                 if(residence.getDueDate().equals(Date.from(ZonedDateTime.now().plusDays(5).toInstant()))) {
                    rentNotifier.notifyTenantWithDueDateForResidence(infobox.getUserEmail(), residence.getAddress());
                }
            }
        }
    }
}

