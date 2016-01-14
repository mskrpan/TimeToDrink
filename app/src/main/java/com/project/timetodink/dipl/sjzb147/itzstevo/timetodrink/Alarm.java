package com.project.timetodink.dipl.sjzb147.itzstevo.timetodrink;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import java.util.Calendar;

/**
 * Created by Stevo on 23.2.2015..
 */
public class Alarm extends ActionBarActivity {

    Intent i = new Intent();
    Switch s1, s2, s3, s4, s5, s6, s7, s8, s9;

    public static final String PREFS = "examplePrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //prikazuje sterlicu za povratak
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Metoda();


        SharedPreferences example = getSharedPreferences(PREFS, MODE_PRIVATE);
        s1.setChecked(example.getBoolean("sw1pref", false));
        s2.setChecked(example.getBoolean("sw2pref", false));
        s3.setChecked(example.getBoolean("sw3pref", false));
        s4.setChecked(example.getBoolean("sw4pref", false));
        s5.setChecked(example.getBoolean("sw5pref", false));
        s6.setChecked(example.getBoolean("sw6pref", false));
        s7.setChecked(example.getBoolean("sw7pref", false));
        s8.setChecked(example.getBoolean("sw8pref", false));
        s9.setChecked(example.getBoolean("sw9pref", false));
    }

    public void Metoda() {
        s1 = (Switch) findViewById(R.id.sOnOff1);
        s2 = (Switch) findViewById(R.id.sOnOff2);
        s3 = (Switch) findViewById(R.id.sOnOff3);
        s4 = (Switch) findViewById(R.id.sOnOff4);
        s5 = (Switch) findViewById(R.id.sOnOff5);
        s6 = (Switch) findViewById(R.id.sOnOff6);
        s7 = (Switch) findViewById(R.id.sOnOff7);
        s8 = (Switch) findViewById(R.id.sOnOff8);
        s9 = (Switch) findViewById(R.id.sOnOff9);
        //s9 = (Switch) findViewById(R.id.sOnOff9);

    }

    // public void ButtonSetAlarm(View view) {

    //     Calendar calendar = Calendar.getInstance();
    //     if (calendar.get(Calendar.HOUR) >= 8) {
    //         calendar.add(Calendar.DATE, 1);
    //     }
    //     calendar.set(Calendar.SECOND, 0);
    //     calendar.set(Calendar.MINUTE, 0);
    //     calendar.set(Calendar.HOUR, 8);
    //     calendar.set(Calendar.AM_PM, Calendar.AM);

    //     AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

    //     Intent myIntent = new Intent(this, NotifyMe.class);

    //    pendingIntent = PendingIntent.getBroadcast(this, 1, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    //    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent);
    //   Toast.makeText(this, "Alarm naređen na 8:00 AM", Toast.LENGTH_SHORT).show();
    // }

    //Alarmi:
    // 6:00 AM
    public void onSwitch(View view) {
        SharedPreferences preferences = getSharedPreferences(PREFS, 0);
        PendingIntent pendingIntent;


        if (s1.isChecked()) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw1pref", true);
            editor.commit();

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
            Toast.makeText(this, "Alarm is set for 6:00 AM", Toast.LENGTH_SHORT).show();

        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw1pref", false);
            editor.commit();

            Intent intent = new Intent(this, NotifyMe.class);
            pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 11, intent, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.cancel(pendingIntent);
        }
    }

    // 8:00 AM
    public void onSwitch_Two(View view) {
        SharedPreferences preferences = getSharedPreferences(PREFS, 0);
        PendingIntent pendingIntent2;

        if (s2.isChecked()) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw2pref", true);
            editor.commit();

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
            Toast.makeText(this, "Alarm is set for 8:00 AM", Toast.LENGTH_SHORT).show();

        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw2pref", false);
            editor.commit();

            Intent intent2 = new Intent(this, NotifyMe.class);
            pendingIntent2 = PendingIntent.getBroadcast(getApplicationContext(), 22, intent2, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.cancel(pendingIntent2);
        }
    }

    // 10:00 AM
    public void onSwitch_Three(View view) {
        SharedPreferences preferences = getSharedPreferences(PREFS, 0);
        PendingIntent pendingIntent3;


        if (s3.isChecked()) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw3pref", true);
            editor.commit();

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
            Toast.makeText(this, "Alarm is set for 10:00 AM", Toast.LENGTH_SHORT).show();

        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw3pref", false);
            editor.commit();

            Intent intent3 = new Intent(this, NotifyMe.class);
            pendingIntent3 = PendingIntent.getBroadcast(getApplicationContext(), 33, intent3, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.cancel(pendingIntent3);
        }
    }

    // 12:00 PM
    public void onSwitch_Four(View view) {
        SharedPreferences preferences = getSharedPreferences(PREFS, 0);
        PendingIntent pendingIntent4;


        if (s4.isChecked()) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw4pref", true);
            editor.commit();

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
            Toast.makeText(this, "Alarm is set for 12:00 PM", Toast.LENGTH_SHORT).show();

        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw4pref", false);
            editor.commit();

            Intent intent4 = new Intent(this, NotifyMe.class);
            pendingIntent4 = PendingIntent.getBroadcast(getApplicationContext(), 44, intent4, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.cancel(pendingIntent4);
        }
    }

    // 2:00 PM
    public void onSwitch_Five(View view) {
        SharedPreferences preferences = getSharedPreferences(PREFS, 0);
        PendingIntent pendingIntent5;


        if (s5.isChecked()) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw5pref", true);
            editor.commit();

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
            Toast.makeText(this, "Alarm is set for 2:00 PM", Toast.LENGTH_SHORT).show();

        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw5pref", false);
            editor.commit();

            Intent intent5 = new Intent(this, NotifyMe.class);
            pendingIntent5 = PendingIntent.getBroadcast(getApplicationContext(), 55, intent5, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.cancel(pendingIntent5);
        }
    }

    // 4:00 PM
    public void onSwitch_Six(View view) {
        SharedPreferences preferences = getSharedPreferences(PREFS, 0);
        PendingIntent pendingIntent6;


        if (s6.isChecked()) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw6pref", true);
            editor.commit();

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
            Toast.makeText(this, "Alarm is set for 4:00 PM", Toast.LENGTH_SHORT).show();

        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw6pref", false);
            editor.commit();

            Intent intent6 = new Intent(this, NotifyMe.class);
            pendingIntent6 = PendingIntent.getBroadcast(getApplicationContext(), 66, intent6, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.cancel(pendingIntent6);
        }
    }

    // 6:00 PM
    public void onSwitch_Seven(View view) {
        SharedPreferences preferences = getSharedPreferences(PREFS, 0);
        PendingIntent pendingIntent7;


        if (s7.isChecked()) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw7pref", true);
            editor.commit();

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
            Toast.makeText(this, "Alarm is set for 6:00 PM", Toast.LENGTH_SHORT).show();

        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw7pref", false);
            editor.commit();

            Intent intent7 = new Intent(this, NotifyMe.class);
            pendingIntent7 = PendingIntent.getBroadcast(getApplicationContext(), 77, intent7, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.cancel(pendingIntent7);
        }
    }

    // 8:00 PM
    public void onSwitch_Eight(View view) {
        SharedPreferences preferences = getSharedPreferences(PREFS, 0);
        PendingIntent pendingIntent8;


        if (s8.isChecked()) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw8pref", true);
            editor.commit();

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
            Toast.makeText(this, "Alarm is set for 8:00 PM", Toast.LENGTH_SHORT).show();

        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw8pref", false);
            editor.commit();

            Intent intent8 = new Intent(this, NotifyMe.class);
            pendingIntent8 = PendingIntent.getBroadcast(getApplicationContext(), 88, intent8, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.cancel(pendingIntent8);
        }
    }

    // 10:00 PM
    public void onSwitch_Nine(View view) {
        SharedPreferences preferences = getSharedPreferences(PREFS, 0);
        PendingIntent pendingIntent9;


        if (s9.isChecked()) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw9pref", true);
            editor.commit();

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
            Toast.makeText(this, "Alarm is set for 10:00 PM", Toast.LENGTH_SHORT).show();

        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sw9pref", false);
            editor.commit();

            Intent intent9 = new Intent(this, NotifyMe.class);
            pendingIntent9 = PendingIntent.getBroadcast(getApplicationContext(), 99, intent9, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.cancel(pendingIntent9);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if ( keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            onBackPressed();
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {

        return;
    }

}
