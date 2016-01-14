package com.project.timetodink.dipl.sjzb147.itzstevo.timetodrink;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;


/**
 * Created by Stevo on 24.3.2015..
 */
public class ListFromDB extends ActionBarListActivity implements WaterListAdapter.ClickCallback{
    Intent i = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_from_db);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //prikazuje sterlicu za povratak
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WaterDBHelper dbHelper = new WaterDBHelper(getBaseContext());
        Cursor cursor = dbHelper.getWaterRows();
        //prebrojat će redove
        int count = cursor.getCount();
        //fildovi u koje ću spremiti pojedine podatke
        int[] id = new int[count];
        float[] amount = new float[count];
        String[] date = new String[count];

        int i = 0;
        while(cursor.moveToNext()){
            id[i] = cursor.getInt(0);
            amount[i] = cursor.getFloat(1);
            date[i] = cursor.getString(2);
            i++;
        }
        setListAdapter(new WaterListAdapter(getApplicationContext(), R.layout.item, id, amount, date, this) );
    }


    public void onListClick(){
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
/*
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        dbHelper.deleteWater(myAdapter.getItem(position));
        myWater.remove(position);
        myAdapter.notifyDataSetChanged();
        return false;
    }*/
}