package co.martinbrown.example.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificationExampleActivity extends Activity {

    Button notificationButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        notificationButton = (Button) findViewById(R.id.button1);

        notificationButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                Intent notificationIntent = new Intent(getApplicationContext(), SecondActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(
                        getApplicationContext(),
                        0,
                        notificationIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                
                Notification notification = new Notification.Builder(getApplicationContext())
                	.setSmallIcon(R.drawable.ic_launcher)
                	.setTicker("Hi there")
                	.setWhen(System.currentTimeMillis())
                	.setContentTitle("You have been notified")
                	.setContentText("Click to launch second activity ...")
                	.setContentIntent(contentIntent)
                	.setAutoCancel(true)
                	.setOnlyAlertOnce(true)
                	.build();

                nm.notify(1, notification);
            }
        });
    }
}