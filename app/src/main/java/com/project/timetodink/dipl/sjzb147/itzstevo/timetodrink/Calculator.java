package com.project.timetodink.dipl.sjzb147.itzstevo.timetodrink;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Stevo on 17.2.2015..
 */
public class Calculator extends ActionBarActivity {

    public static final String PREFS = "examplePrefs";

    Intent i = new Intent();
    EditText etCalculator, etTemperatura, etVjezba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //prikazuje sterlicu za povratak
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Init();
    }

    public void Init(){
        etCalculator = (EditText) findViewById(R.id.etCalculator);
        etTemperatura = (EditText) findViewById(R.id.etTemperatura);
        etVjezba = (EditText) findViewById(R.id.etVjezba);
    }

    public void ButtonCalculate(View view){

        if(etCalculator.getText().toString().equals("")) {
            etCalculator.setText("0");
        }
        if(etVjezba.getText().toString().equals("")) {
            etVjezba.setText("0");
        }
        if(etTemperatura.getText().toString().equals("")) {
            etTemperatura.setText("0");
        }

        //Integer.parseInt(etCalculator.getText().toString());
        String number = etCalculator.getText().toString();
        String numberr = etTemperatura.getText().toString();
        String numberrr = etVjezba.getText().toString();
        float newnumber = Float.parseFloat(number);
        float newnumberr = Float.parseFloat(numberr);
        float newnumberrr = Float.parseFloat(numberrr);

        //računanje na osnovu kg
        float ml = 0;
        ml = newnumber*25;

        //preraÄŤunavanje na temelju tjelovjeĹľbe;
        float tjelo = 0;
        tjelo = (newnumberr * 5);

        //preraÄŤunavanje temperature
        float temp = 0;

        if (newnumberrr >=20 && newnumberrr < 30)
            temp = 200;
        if (newnumberrr >= 30)
            temp = 500;


        //memoriranje vrijednosti
        SharedPreferences examplePrefs = getSharedPreferences(PREFS, 0);
        SharedPreferences.Editor editor = examplePrefs.edit();
        editor.putFloat("userMessage", ml);
        //može se stavit više editora i to po potrebi
        editor.putFloat("userMessageReset", ml);
        editor.putString("referanceDate", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));
        editor.commit();
        i.setClass(this, MainActivity.class);
        this.startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
/*
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/

        //ovim definiramo da ako je pritisnut home strelica vrati nas u naš parent activity s naredbom
        //NavUtils.navigateUP
        if (id==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
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
}
