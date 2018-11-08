package com.landlordcommunication.web.notification_tools;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class RentNotifier {

    @Autowired
    AndroidPushNotificationsService androidPushNotificationsService;

    public void notifyTenantWithDueDateForResidence(String userEmail, String residenceAddress){
        JSONObject body = new JSONObject();
        body.put("to", "/topics/" + userEmail);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", "Rent due in 5 days");
        notification.put("body", residenceAddress);

        body.put("notification", notification);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

    }

}
