package com.project.timetodink.dipl.sjzb147.itzstevo.timetodrink;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Stevo on 14.3.2015..
 */
public class RebootDevice extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
            Intent intentAlarm = new Intent(context, RebootAlarms.class);
            intentAlarm.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startService(intentAlarm);
    }
}
