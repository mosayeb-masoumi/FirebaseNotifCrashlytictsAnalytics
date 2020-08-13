package com.example.firebasenotifcrashlytictsanalytics;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {

        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setContentText(remoteMessage.getNotification().getBody())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setSound(uri)
                .build();

        NotificationManagerCompat manager = NotificationManagerCompat.from(getApplicationContext());
        manager.notify(0, notification);

    }



    // to handle getting data
    @Override
    public void handleIntent(Intent intent) {
        super.handleIntent(intent);
        Bundle bundle = intent.getExtras();
        if (bundle != null) {

                                       // the key where we defined in firebase console
            String ali = bundle.getString("ali");
            String hasan = bundle.getString("hasan");

        }
    }
}
