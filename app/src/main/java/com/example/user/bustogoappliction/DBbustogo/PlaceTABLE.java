package com.example.user.bustogoappliction.DBbustogo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by KengKung on 16/8/2560.
 */

public class PlaceTABLE {

    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSQLiteDataBase,readSQLiteDataBase;

    public static final String PLACE_TABLE = "placeTABLE";
    public static final String PLACE_ID = "id_place";
    public static final String PLACE_NAME = "name_place";
    public static final String PLACE_PIC = "pic_place";
    public static final String PLACE_DETAIL = "detail_place";
    public static final String PLACE_LAT = "lat_place";
    public static final String PLACE_LONG = "long_place";
    public static final String PLACE_BUS = "bus_place";

    public PlaceTABLE(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSQLiteDataBase = objMySQLiteOpenHelper.getWritableDatabase();
        readSQLiteDataBase = objMySQLiteOpenHelper.getReadableDatabase();
    }
    public long AddNewPlace(String strNP,String strPP,String strPD,String strPLA,String strPLO,String strPB){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(objMySQLiteOpenHelper.PLACE_NAME,strNP);
        objContentValues.put(objMySQLiteOpenHelper.PLACE_PIC,strPP);
        objContentValues.put(objMySQLiteOpenHelper.PLACE_DETAIL,strPD);
        objContentValues.put(objMySQLiteOpenHelper.PLACE_LAT,strPLA);
        objContentValues.put(objMySQLiteOpenHelper.PLACE_LONG,strPLO);
        objContentValues.put(objMySQLiteOpenHelper.PLACE_BUS,strPB);
        return readSQLiteDataBase.insert(objMySQLiteOpenHelper.PLACE_TABLE,null,objContentValues);
    }
    public String[] readDBplaceTABLE(int intplace){
        try{
            String[] strResult = null;
            Cursor objCursor = readSQLiteDataBase.query(PLACE_TABLE, new String[]{PLACE_NAME,PLACE_DETAIL,PLACE_PIC},null,null,null,null,null);
            if(objCursor != null){
                if(objCursor.moveToFirst()){
                    strResult = new String[3];
                    for (int i=0;i<3;i++){
                        strResult[i]= objCursor.getString(intplace);
                        objCursor.moveToNext();
                    }
                }
            }
            objCursor.close();
            return strResult;
        }catch (Exception e){
            return null;
        }
    }

}
