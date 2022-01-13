package com.gmail.mateendev3.androidnotifications;

import android.app.Notification;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.gmail.mateendev3.androidnotifications.application.App;

public class MainActivity extends AppCompatActivity {

    //declaring members
    EditText etTitle, etMessage;
    Button btnNotificationFromChannel1, btnNotificationFromChannel1Again,
            btnNotificationFromChannel2;
    NotificationManagerCompat mManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //method invoked to initialize members
        initViews();
        //method to set listeners to buttons
        setListenersToButtons();

    }
    /**
     * Method to set listeners to buttons
     */
    private void setListenersToButtons() {

        btnNotificationFromChannel1.setOnClickListener(v -> {

            if (!etHasEmpty()) {
                String title = etTitle.getText().toString();
                String text = etMessage.getText().toString();

                Toast.makeText(MainActivity.this, title + " " + text, Toast.LENGTH_SHORT).show();
                //creating notification
                Notification notification = new NotificationCompat.Builder(
                        MainActivity.this,
                        "channel.id.1"
                )
                        .setSmallIcon(R.drawable.ic_one)
                        .setContentTitle(title)
                        .setContentText(text)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .build();

                //setting notification to notification manager to handle it
                mManager.notify(1, notification);
            }
        });
    }
    /**
     * Method to check that edit texts are empty or not
     * @return true if ets are empty else false
     */
    private boolean etHasEmpty() {
        return TextUtils.isEmpty(etTitle.getText().toString()) &&
                TextUtils.isEmpty(etMessage.getText().toString());
    }
    /**
     * Method to initializing views
     */
    private void initViews() {
        etTitle = findViewById(R.id.et_title);
        etMessage = findViewById(R.id.et_message);
        btnNotificationFromChannel1 = findViewById(R.id.btn_notification_from_channel_1);
        btnNotificationFromChannel1Again = findViewById(R.id.btn_notification_from_channel_1_again);
        btnNotificationFromChannel2 = findViewById(R.id.btn_notification_from_channel_2);
        mManager = NotificationManagerCompat.from(this);
    }
}