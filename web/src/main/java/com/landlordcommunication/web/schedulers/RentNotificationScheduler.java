package com.landlordcommunication.web.schedulers;

import com.landlordcommunication.web.models.RentNotificationInfo;
import com.landlordcommunication.web.models.Residence;
import com.landlordcommunication.web.notification_tools.RentNotifier;
import com.landlordcommunication.web.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class RentNotificationScheduler {
    private static final Logger logger = LoggerFactory.getLogger(MessageCleaningScheduler.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final int DAYS_BEFORE_RENT_DUE_DATE = 5;

    private UserService userService;

    private RentNotifier rentNotifier;

    public RentNotificationScheduler() {
    }

    @Autowired
    public RentNotificationScheduler(UserService userService, RentNotifier rentNotifier) {
        this.userService = userService;
        this.rentNotifier = rentNotifier;
    }

    //cron expression below should be "0 * * * * ?" for every minute (testing)
    // or "0 0 12 * * ?" for every day at noon
    @Scheduled(cron = "0 0 12 * * ?")
    public void scheduleTaskWithCronExpression() {
        logger.info("Rent notifications checked and sent :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

        for (RentNotificationInfo infobox : userService.getRentNotificationInfo()) {
            for (Residence residence : infobox.getResidences()){
                //to notify tenants 5 days prior to the rent's due date per project specifications
                 if(compareDates(residence.getDueDate(), Date.from(ZonedDateTime.now().plusDays(DAYS_BEFORE_RENT_DUE_DATE).toInstant()))) {
                    rentNotifier.notifyTenantWithDueDateForResidence(infobox.getUserEmail(), residence.getAddress());
                }
            }
        }
    }

    private boolean compareDates(Date dueDate, Date currentDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(dueDate).equals(sdf.format(currentDate));

    }
}

