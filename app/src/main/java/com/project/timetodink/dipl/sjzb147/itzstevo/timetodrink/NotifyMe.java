package com.project.timetodink.dipl.sjzb147.itzstevo.timetodrink;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;

/**
 * Created by Stevo on 23.2.2015..
 */
public class NotifyMe extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Calendar calendar = Calendar.getInstance();
        if (calendar.get(Calendar.HOUR_OF_DAY) == 6 && calendar.get(Calendar.MINUTE) == 0 && calendar.get(Calendar.AM_PM) == Calendar.AM) {

            createNotification(context, "Time To Drink", "It is time to drink!", "Water Alarm");
        }

        if (calendar.get(Calendar.HOUR_OF_DAY) == 8 && calendar.get(Calendar.MINUTE) == 0 && calendar.get(Calendar.AM_PM) == Calendar.AM) {

            createNotification(context, "Time To Drink", "It is time to drink!", "Water Alarm");
        }

        if (calendar.get(Calendar.HOUR_OF_DAY) == 10 && calendar.get(Calendar.MINUTE) == 0 && calendar.get(Calendar.AM_PM) == Calendar.AM) {

            createNotification(context, "Time To Drink", "It is time to drink!", "Water Alarm");
        }

        if (calendar.get(Calendar.HOUR_OF_DAY) == 12 && calendar.get(Calendar.MINUTE) == 0 && calendar.get(Calendar.AM_PM) == Calendar.PM) {

            createNotification(context, "Time To Drink", "It is time to drink!", "Water Alarm");
        }

        if (calendar.get(Calendar.HOUR) == 2 && calendar.get(Calendar.MINUTE) == 0 && calendar.get(Calendar.AM_PM) == Calendar.PM) {

            createNotification(context, "Time To Drink", "It is time to drink!", "Water Alarm");
        }

        if (calendar.get(Calendar.HOUR) == 4 && calendar.get(Calendar.MINUTE) == 0 && calendar.get(Calendar.AM_PM) == Calendar.PM) {

            createNotification(context, "Time To Drink", "It is time to drink!", "Water Alarm");
        }

        if (calendar.get(Calendar.HOUR) == 6 && calendar.get(Calendar.MINUTE) == 0 && calendar.get(Calendar.AM_PM) == Calendar.PM) {

            createNotification(context, "Time To Drink", "It is time to drink!", "Water Alarm");
        }

        if (calendar.get(Calendar.HOUR) == 8 && calendar.get(Calendar.MINUTE) == 0 && calendar.get(Calendar.AM_PM) == Calendar.PM) {

            createNotification(context, "Time To Drink", "It is time to drink!", "Water Alarm");
        }

        if (calendar.get(Calendar.HOUR) == 10 && calendar.get(Calendar.MINUTE) == 0 && calendar.get(Calendar.AM_PM) == Calendar.PM) {

            createNotification(context, "Time To Drink", "It is time to drink!", "Water Alarm");
        }

    }

    private void createNotification(Context context, String msg, String msgText, String msgAlert) {

        PendingIntent notificIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.water)
                .setContentTitle(msg)
                .setTicker(msgAlert)
                .setContentText(msgText);

        mBuilder.setContentIntent(notificIntent);
        mBuilder.setSound(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.drawable.water_splash));
        //mBuilder.setAutoCancel(true);

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(99, mBuilder.build());

    }
}
