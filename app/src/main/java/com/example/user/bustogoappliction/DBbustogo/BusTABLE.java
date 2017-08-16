package com.example.user.bustogoappliction.DBbustogo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by KengKung on 16/8/2560.
 */

public class BusTABLE {
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSQLiteDataBase, readSQLiteDataBase;

    public static final String BUS_TABLE = "busTABLE";
    public static final String BUS_ID = "id_bus";
    public static final String BUS_PIC = "pic_bus";
    public static final String BUS_DETAIL = "detail_bus";

    public BusTABLE(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSQLiteDataBase = objMySQLiteOpenHelper.getWritableDatabase();
        readSQLiteDataBase = objMySQLiteOpenHelper.getReadableDatabase();
    }
    public long AddNewBus(String strBP,String strBD){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(objMySQLiteOpenHelper.BUS_PIC,strBP);
        objContentValues.put(objMySQLiteOpenHelper.BUS_DETAIL,strBD);
        return readSQLiteDataBase.insert(objMySQLiteOpenHelper.BUS_TABLE,null,objContentValues);
    }
}
