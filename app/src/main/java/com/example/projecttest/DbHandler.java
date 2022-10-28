package com.example.projecttest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {

    private static final String TAG = "DbHandler";



    public DbHandler(@Nullable Context context) {
        super(context, "myDatabase", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists myTable(id integer primary key autoincrement,cardName text,cardNumber number,month number,year number,ccv number)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists myTable");
        onCreate(db);

    }

    public void insertData(Data data){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("cardName",data.getCardName());
        contentValues.put("cardNumber",data.getCardNumber());
        contentValues.put("month",data.getMonth());
        contentValues.put("year",data.getYear());
        contentValues.put("ccv",data.getCcv());


        long myTable = sqLiteDatabase.insert("myTable", null, contentValues);
        Log.e(TAG,"insertData "+myTable);

    }
}
