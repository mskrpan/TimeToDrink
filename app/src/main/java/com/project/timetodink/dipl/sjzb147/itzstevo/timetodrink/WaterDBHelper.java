package com.project.timetodink.dipl.sjzb147.itzstevo.timetodrink;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Stevo on 4.3.2015..
 */
public class WaterDBHelper {
    //verzija baze
    private static final int DATABASE_VERSION = 2;
    //ime baze i svih tablica
    private static final String DATABASE_NAME = "waterInfo";
    private static final String TABLE_WATER = "water";
    //stupci u tablici
    private static final String KEY_ID = "_id";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_DATE = "date";

    private final dbOpenControl dbOpenHelp;
    private final SQLiteDatabase db;

    //konstruktor
    public WaterDBHelper(Context context){
        dbOpenHelp = new dbOpenControl(context, DATABASE_NAME, DATABASE_VERSION);
        db = dbOpenHelp.getWritableDatabase();
    }

    //CRUD umetanje:
    public void addAmount(float amount, String date){

        ContentValues values = new ContentValues(2);
        values.put(KEY_AMOUNT, amount);
        values.put(KEY_DATE, date);

        db.insert(TABLE_WATER, null, values);
    }

    public void updateAmount(int id, float amount){
        ContentValues values = new ContentValues(1);
        values.put(KEY_AMOUNT, amount);

        db.update(TABLE_WATER, values, KEY_ID + " = " + String.valueOf(id), null);
    }
    //dohvaÄ‡anje liste svih koliÄŤina
    /**
    public ArrayList<Water> getWater(){
        ArrayList<Water> waters = new ArrayList<Water>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_WATER, new String[]{KEY_ID, KEY_AMOUNT, KEY_DATE}, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                Water water = new Water(
                        cursor.getInt(0), cursor.getFloat(1), cursor.getString(2));
                waters.add(water);
            }while (cursor.moveToNext());
        }
        db.close();
        return waters;
    }
    */
    public Cursor getWaterRows(){
        return db.query(TABLE_WATER, new String[]{KEY_ID, KEY_AMOUNT, KEY_DATE}, null, null, null, null, KEY_DATE + " DESC");
    }
    /*/brisanje po id-u
    public void deleteWater(Water water){
        int id = water.getId();
        String[] arg = new String[]{String.valueOf(id)};
        db.delete(TABLE_WATER, KEY_ID + "=?", arg);
        db.close();
    }*/



    private static class dbOpenControl extends SQLiteOpenHelper {

        private static final String CREATE_WATER_TABLE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_WATER
                + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_AMOUNT + " FLOAT, "
                + KEY_DATE + " TEXT"
                + ")";
       // + KEY_DATE + " TEXT"

        dbOpenControl(Context context, String name, int version) {
            super(context, name, null, version);
        }

        //kod inicijalnog kreiranja baze:
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_WATER_TABLE);
        }

        //najjednostavniji naÄŤin upgradea - briĹˇu se svi podatci:
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE " + TABLE_WATER);
            onCreate(db);
        }
    }
}
