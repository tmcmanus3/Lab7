package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText title;
    private EditText message;
    private Button channel1;
    private Button channel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (EditText) findViewById(R.id.title);
        message = (EditText) findViewById(R.id.message);
        channel1 = (Button) findViewById(R.id.channel1);
        channel2 = (Button) findViewById(R.id.channel2);

        notificationManager = NotificationManagerCompat.from(this);

        channel1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sendOnChannel1();
                    }
                }
        );

        channel2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sendOnChannel2();
                    }
                }
        );

    }

    public void sendOnChannel1() {
        String titleContent = title.getText().toString();
        String messageContent = message.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(titleContent)
                .setContentText(messageContent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        Log.i(titleContent, messageContent);
        notificationManager.notify(1,notification);
    }

    public void sendOnChannel2() {
        String titleContent = title.getText().toString();
        String messageContent = message.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(titleContent)
                .setContentText(messageContent)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        Log.i(titleContent, messageContent);
        notificationManager.notify(1,notification);
    }
}