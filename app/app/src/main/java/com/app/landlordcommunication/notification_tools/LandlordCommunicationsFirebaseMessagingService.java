package com.app.landlordcommunication.notification_tools;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.app.landlordcommunication.views.ChatScreen.ChatScreenActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class LandlordCommunicationsFirebaseMessagingService extends FirebaseMessagingService {

    private final String TAG = "JSA-FCM";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        if (remoteMessage.getNotification() != null) {

            //if the notification is about a new chat message and you're in the chat activity
            //do not display it on screen, but rather log it in the background
            if(remoteMessage.getNotification().getTitle().equals("You have a new message from")) {
                if (!ChatScreenActivity.isActive) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(() -> Toast.makeText(getApplicationContext(),
                            remoteMessage.getNotification().getTitle() + " " + remoteMessage.getNotification().getBody(),
                            Toast.LENGTH_LONG).show());
                } else {
                    Log.e(TAG, "Title: " + remoteMessage.getNotification().getTitle());
                    Log.e(TAG, "Body: " + remoteMessage.getNotification().getBody());
                }
            }
            //if the notification is not about a new chat message,
            // it will display on screen regardless of the chat screen activity
            if(!remoteMessage.getNotification().getTitle().equals("You have a new message from")){
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(() -> Toast.makeText(getApplicationContext(),
                        remoteMessage.getNotification().getTitle() + " " + remoteMessage.getNotification().getBody(),
                        Toast.LENGTH_LONG).show());
            }

            //no plans to use notifications with data for now
            /*if (remoteMessage.getData().size() > 0) {
                Log.e(TAG, "Data: " + remoteMessage.getData());
            }*/

        }

    }
}