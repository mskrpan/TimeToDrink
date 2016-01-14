package com.project.timetodink.dipl.sjzb147.itzstevo.timetodrink;


import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import at.grabner.circleprogress.CircleProgressView;


public class MainActivity extends ActionBarActivity implements PopupMenu.OnMenuItemClickListener {

    ////--------------------------------------
    CircleProgressView mCircleView;


    Toolbar toolbar;

    public static final String PREFS = "examplePrefs";


    Intent i = new Intent();
    TextView tvNumber, tvTest;
    Button bDrink;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////--------------------------------------------------------
        mCircleView = (CircleProgressView) findViewById(R.id.circleView);
        mCircleView.setUnit("%");
        mCircleView.setShowUnit(true);
        mCircleView.setAutoTextSize(true);
        ////------------------------------------------------------------

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //prikazuje fragment kao slide
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //kreiranje fragmenta kao objekta
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        //pozivamo metodu iz navigation classe gdje u biti passamo sve
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

       // baseContext = getBaseContext();


        Init();


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();

        SharedPreferences example = getSharedPreferences(PREFS, 0);
        Float userFloat = example.getFloat("userMessage", 0);
        Float userReset = example.getFloat("userMessageReset", 0);

        String str1 = example.getString("referanceDate", "");
        String str2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date());
        ////--------------------------------------
        mCircleView.setMaxValue(userReset);
        mCircleView.setValue(0);
        if(userFloat == 0 || userReset == 0);
        {
            mCircleView.setValue(0);
            mCircleView.setValueAnimated(0);
        }
        mCircleView.setValueAnimated(userFloat);
        ////--------------------------------------
        tvNumber.setText(Float.toString(userFloat));
        if (userFloat <= 0) {
            bDrink.setEnabled(false);
        }
        if ((str2.length() > 10) && (str1.length() > 10) && (!str2.substring(0, 10).equals(str1.substring(0, 10)))) {
            bDrink.setEnabled(true);
            SharedPreferences.Editor editor = example.edit();
            editor.putString("referanceDate", str2);
            editor.commit();
            ////--------------------------------------
            mCircleView.setValueAnimated(userReset);
            ////---------------------------------------
            tvNumber.setText(Float.toString(userReset));
            String test = tvNumber.getText().toString();
            editor.putFloat("userMessage", Float.parseFloat(test));
            editor.apply();
        }
    }

    public void Init() {
        tvNumber = (TextView) findViewById(R.id.tvNumber);
        //tvTest = (TextView) findViewById(R.id.tvTest);
        bDrink = (Button) findViewById(R.id.bDrinkWater);

    }

    public void ButtonDrink(View view) {

        final CharSequence[] items = {"100ml", "200ml", "300ml"};
        final AlertDialog.Builder alertDialog;
        alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Chose amount of water:").setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SharedPreferences example = getSharedPreferences(PREFS, 0);
                Float userReset = example.getFloat("userMessageReset", 0);

                WaterDBHelper dbHelper = new WaterDBHelper(getBaseContext());
                Cursor cursor = dbHelper.getWaterRows();

                switch (which) {
                    case 0:
                        String changedNumber = tvNumber.getText().toString();
                        float newChangedNumber = Float.parseFloat(changedNumber);
                        float finalValue;
                        finalValue = (newChangedNumber - 100);
                        tvNumber.setText(Float.toString(finalValue));
                        if (finalValue <= 0) {
                            tvNumber.setText("0.0");
                            finalValue = 0;
                            Toast.makeText(getApplicationContext(), "Gz gz all out!!! =)", Toast.LENGTH_SHORT).show();
                            bDrink.setEnabled(false);
                        }
                        SharedPreferences.Editor editor = example.edit();
                        editor.putFloat("userMessage", finalValue);
                        editor.apply();

                        mCircleView.setValueAnimated(finalValue);


                        boolean found = false;
                        while(cursor.moveToNext()&& !found){


                            if ((getDateTime().equals(cursor.getString(2))) && (finalValue != -1)) {
                                //Float userReset = examplePrefs.getFloat("userMessageReset", 0);
                                dbHelper.updateAmount(cursor.getInt(0), userReset-finalValue);
                                found = true;

                            }
                        }

                        if (!found  && (finalValue != -1))
                            dbHelper.addAmount(100, getDateTime());
                        dialog.cancel();
                        break;

                    case 1:
                        String changedNumber2 = tvNumber.getText().toString();
                        float newChangedNumber2 = Float.parseFloat(changedNumber2);
                        float finalValue2;
                        finalValue2 = (newChangedNumber2 - 200);
                        tvNumber.setText(Float.toString(finalValue2));
                        if (finalValue2 <= 0) {
                            tvNumber.setText("0.0");
                            finalValue2 = 0;
                            Toast.makeText(getApplicationContext(), "Gz gz all out!!! =)", Toast.LENGTH_SHORT).show();
                            bDrink.setEnabled(false);
                        }

                        SharedPreferences.Editor editor2 = example.edit();
                        editor2.putFloat("userMessage", finalValue2);
                        editor2.apply();

                        mCircleView.setValueAnimated(finalValue2);

                        boolean founde = false;
                        while(cursor.moveToNext()&& !founde){


                            if ((getDateTime().equals(cursor.getString(2))) && (finalValue2 != -1)) {
                                // Float userReset = examplePrefs2.getFloat("userMessageReset", 0);
                                dbHelper.updateAmount(cursor.getInt(0), userReset-finalValue2);
                                founde = true;

                            }
                        }

                        if (!founde  && (finalValue2 != -1))
                            dbHelper.addAmount(200, getDateTime());
                        dialog.cancel();
                        break;

                    case 2:
                        String changedNumber3 = tvNumber.getText().toString();
                        float newChangedNumber3 = Float.parseFloat(changedNumber3);
                        float finalValue3;
                        finalValue3 = (newChangedNumber3 - 300);
                        tvNumber.setText(Float.toString(finalValue3));
                        if (finalValue3 <= 0) {
                            tvNumber.setText("0.0");
                            finalValue3 = 0;
                            Toast.makeText(getApplicationContext(), "Gz gz all out!!! =)", Toast.LENGTH_SHORT).show();
                            bDrink.setEnabled(false);
                        }
                        SharedPreferences.Editor editor3 = example.edit();
                        editor3.putFloat("userMessage", finalValue3);
                        editor3.apply();

                        mCircleView.setValueAnimated(finalValue3);

                        boolean foundee = false;
                        while(cursor.moveToNext()&& !foundee){


                            if ((getDateTime().equals(cursor.getString(2))) && (finalValue3 != -1)) {
                                //Float userReset = examplePrefs3.getFloat("userMessageReset", 0);
                                dbHelper.updateAmount(cursor.getInt(0), userReset-finalValue3);
                                foundee = true;

                            }
                        }

                        if (!foundee  && (finalValue3 != -1))
                            dbHelper.addAmount(300, getDateTime());
                        dialog.cancel();
                        break;
                }
            }
        }).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
    public String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy.MM.dd", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
