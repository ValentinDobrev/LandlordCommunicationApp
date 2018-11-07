package com.app.landlordcommunication.background;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService {

        private final String TAG = "JSA-FCM";

        @Override
        public void onMessageReceived(RemoteMessage remoteMessage) {

            //TODO make sure we find a way to display received messages on the UI when app is turned on

            //this part of the code logs the message in logcat
            if (remoteMessage.getNotification() != null) {
                Log.e(TAG, "Title: " + remoteMessage.getNotification().getTitle());
                Log.e(TAG, "Body: " + remoteMessage.getNotification().getBody());
            }

            if (remoteMessage.getData().size() > 0) {
                Log.e(TAG, "Data: " + remoteMessage.getData());
            }


        }


}