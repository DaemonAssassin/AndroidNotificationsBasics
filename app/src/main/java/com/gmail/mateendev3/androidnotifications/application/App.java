package com.gmail.mateendev3.androidnotifications.application;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    //declaring members / constants
    public static final String CHANNEL_ID_1 = "channel.id.1";
    public static final String CHANNEL_ID_2 = "channel.id.2";
    NotificationManagerCompat mManager;


    @Override
    public void onCreate() {
        super.onCreate();

        //instantiating manager
        mManager = NotificationManagerCompat.from(this);

        //method invoked to create channels
        createNotificationChannels();
    }

    /**
     * Method to create notification channels for API Lever 26 and above.
     */
    private void createNotificationChannels() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            //creating channel 1
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_ID_1,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This category is for audio notifications");

            //creating channel 2
            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_ID_2,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel2.setDescription("This category is for video notifications");

            //SETTING CHANNELS WITH MANAGER FOR MANAGEMENT
            List<NotificationChannel> channels = new ArrayList<>();
            channels.add(channel1);
            channels.add(channel2);
            mManager.createNotificationChannels(channels);
        }
    }
}
