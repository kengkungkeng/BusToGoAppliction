package com.example.user.bustogoappliction.DBbustogo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by KengKung on 16/8/2560.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private final String TAG = getClass().getSimpleName();
    private SQLiteDatabase sqLiteDatabase;

    public static final String DataBase_Name = "bus.db";
    public static final int DataBase_Version = 1;

    public static final String PLACE_TABLE = "PlaceTABLE";
    public static final String PLACE_ID = "id_place";
    public static final String PLACE_NAME = "name_place";
    public static final String PLACE_PIC = "pic_place";
    public static final String PLACE_DETAIL = "detail_place";
    public static final String PLACE_LAT = "lat_place";
    public static final String PLACE_LONG = "long_place";
    public static final String PLACE_BUS = "bus_place";
    public String CREATE_PLACE_TABLE = "create table "+PLACE_TABLE+"("+PLACE_ID+" integer primary key,"+" "+PLACE_NAME+" text,"+PLACE_DETAIL+" text,"+PLACE_PIC+" text,"+PLACE_LAT+" text,"+PLACE_LONG+" text,"+PLACE_BUS+" integer);";

    public static final String BUS_TABLE = "BusTABLE";
    public static final String BUS_ID = "id_bus";
    public static final String BUS_PIC = "pic_bus";
    public static final String BUS_DETAIL = "detail_bus";
    public String CREATE_BUS_TABLE = "create table "+BUS_TABLE+"("+BUS_ID+" integer primary key,"+" "+BUS_PIC+" text,"+BUS_DETAIL+" text);";


    public MySQLiteOpenHelper(Context context){
        super(context,DataBase_Name,null,DataBase_Version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, CREATE_PLACE_TABLE);
        Log.i(TAG, CREATE_BUS_TABLE);
        db.execSQL(CREATE_PLACE_TABLE);
        db.execSQL(CREATE_BUS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
