package com.project.timetodink.dipl.sjzb147.itzstevo.timetodrink;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;

import java.util.Calendar;

/**
 * Created by Stevo on 14.3.2015..
 */
public class RebootAlarms extends Service {
    public static final String PREFS = "examplePrefs";

    @Override
    public void onCreate() {
        super.onCreate();
        checkSwitch();
    }


    public void checkSwitch() {
        SharedPreferences example = getSharedPreferences(PREFS, 0);
        Boolean alarm1 = example.getBoolean("sw1pref", false);
        Boolean alarm2 = example.getBoolean("sw2pref", false);
        Boolean alarm3 = example.getBoolean("sw3pref", false);
        Boolean alarm4 = example.getBoolean("sw4pref", false);
        Boolean alarm5 = example.getBoolean("sw5pref", false);
        Boolean alarm6 = example.getBoolean("sw6pref", false);
        Boolean alarm7 = example.getBoolean("sw7pref", false);
        Boolean alarm8 = example.getBoolean("sw8pref", false);
        Boolean alarm9 = example.getBoolean("sw9pref", false);


        if (alarm1 == true) {
            PendingIntent pendingIntent;
            Calendar calendar = Calendar.getInstance();
            if (calendar.get(Calendar.HOUR_OF_DAY) >= 6 && calendar.get(Calendar.AM_PM) == Calendar.PM) {
                calendar.add(Calendar.DATE, 1);
            }
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR, 6);
            calendar.set(Calendar.AM_PM, Calendar.AM);

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent myIntent = new Intent(this, NotifyMe.class);

            pendingIntent = PendingIntent.getBroadcast(this, 11, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent);
        }
        if (alarm2 == true) {
            PendingIntent pendingIntent2;
            Calendar calendar = Calendar.getInstance();
            if (calendar.get(Calendar.HOUR_OF_DAY) >= 8 && calendar.get(Calendar.AM_PM) == Calendar.PM) {
                calendar.add(Calendar.DATE, 1);
            }
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR, 8);
            calendar.set(Calendar.AM_PM, Calendar.AM);

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent myIntent2 = new Intent(this, NotifyMe.class);

            pendingIntent2 = PendingIntent.getBroadcast(this, 22, myIntent2, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent2);
        }
        if (alarm3 == true) {
            PendingIntent pendingIntent3;
            Calendar calendar = Calendar.getInstance();
            if (calendar.get(Calendar.HOUR_OF_DAY) >= 10 && calendar.get(Calendar.AM_PM) == Calendar.PM) {
                calendar.add(Calendar.DATE, 1);
            }
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR, 10);
            calendar.set(Calendar.AM_PM, Calendar.AM);

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent myIntent3 = new Intent(this, NotifyMe.class);

            pendingIntent3 = PendingIntent.getBroadcast(this, 33, myIntent3, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent3);
        }
        if (alarm4 == true) {
            PendingIntent pendingIntent4;
            Calendar calendar = Calendar.getInstance();
            if (calendar.get(Calendar.HOUR_OF_DAY) >= 12 && calendar.get(Calendar.AM_PM) == Calendar.PM) {
                calendar.add(Calendar.DATE, 1);
            }
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR, 12);
            calendar.set(Calendar.AM_PM, Calendar.AM);

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent myIntent4 = new Intent(this, NotifyMe.class);

            pendingIntent4 = PendingIntent.getBroadcast(this, 44, myIntent4, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent4);
        }
        if (alarm5 == true) {
            PendingIntent pendingIntent5;
            Calendar calendar = Calendar.getInstance();
            if (calendar.get(Calendar.HOUR) >= 2 && calendar.get(Calendar.AM_PM) == Calendar.PM) {
                calendar.add(Calendar.DATE, 1);
            }
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR, 2);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent myIntent5 = new Intent(this, NotifyMe.class);

            pendingIntent5 = PendingIntent.getBroadcast(this, 55, myIntent5, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent5);
        }
        if (alarm6 == true) {
            PendingIntent pendingIntent6;
            Calendar calendar = Calendar.getInstance();
            if (calendar.get(Calendar.HOUR) >= 4 && calendar.get(Calendar.AM_PM) == Calendar.PM) {
                calendar.add(Calendar.DATE, 1);
            }
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR, 4);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent myIntent6 = new Intent(this, NotifyMe.class);

            pendingIntent6 = PendingIntent.getBroadcast(this, 66, myIntent6, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent6);
        }


        if (alarm7 == true) {
            PendingIntent pendingIntent7;
            Calendar calendar = Calendar.getInstance();
            if (calendar.get(Calendar.HOUR) >= 6 && calendar.get(Calendar.AM_PM) == Calendar.PM) {
                calendar.add(Calendar.DATE, 1);
            }
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR, 6);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent myIntent7 = new Intent(this, NotifyMe.class);

            pendingIntent7 = PendingIntent.getBroadcast(this, 77, myIntent7, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent7);
        }
        if (alarm8 == true) {
            PendingIntent pendingIntent8;
            Calendar calendar = Calendar.getInstance();
            if (calendar.get(Calendar.HOUR) >= 8 && calendar.get(Calendar.AM_PM) == Calendar.PM) {
                calendar.add(Calendar.DATE, 1);
            }
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR, 8);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent myIntent8 = new Intent(this, NotifyMe.class);

            pendingIntent8 = PendingIntent.getBroadcast(this, 88, myIntent8, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent8);
        }
        if (alarm9 == true) {
            PendingIntent pendingIntent9;
            Calendar calendar = Calendar.getInstance();
            if (calendar.get(Calendar.HOUR) >= 10 && calendar.get(Calendar.AM_PM) == Calendar.PM) {
                calendar.add(Calendar.DATE, 1);
            }
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR, 10);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent myIntent9 = new Intent(this, NotifyMe.class);

            pendingIntent9 = PendingIntent.getBroadcast(this, 99, myIntent9, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent9);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
