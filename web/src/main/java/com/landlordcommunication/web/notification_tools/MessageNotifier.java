package com.landlordcommunication.web.notification_tools;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class MessageNotifier {

    @Autowired
    AndroidPushNotificationsService androidPushNotificationsService;

    public void notifyReceiverOnNewMessageSent(String receiverEmail, String senderName){
        JSONObject body = new JSONObject();
        body.put("to", "/topics/" + receiverEmail);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", "You have a new message from");
        notification.put("body", senderName);

        body.put("notification", notification);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

    }
}
