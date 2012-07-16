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

                Notification notification = new Notification(R.drawable.ic_launcher,
                        "Hi there",
                        System.currentTimeMillis());

                CharSequence contentTitle = "You have been notified";
                CharSequence contentText = "Click to launch second activity ...";
                Intent notificationIntent = new Intent(getApplicationContext(), SecondActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(
                        getApplicationContext(),
                        0,
                        notificationIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                notification.setLatestEventInfo(getApplicationContext(), contentTitle, contentText, contentIntent);

                notification.flags = Notification.FLAG_AUTO_CANCEL | Notification.FLAG_ONLY_ALERT_ONCE;

                nm.notify(1, notification);
            }
        });
    }
}