package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "TrainProject.db";

    public DBHelper(Context context) {
        super(context, "TrainProject.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT, email TEXT, fullname TEXT)");
        MyDB.execSQL("create Table trains(id TEXT primary key, departure TEXT, arrival TEXT, date TEXT, total_seats TEXT)");
        MyDB.execSQL("create Table admin(username TEXT primary key, password TEXT, email TEXT, fullname TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists trains");
        MyDB.execSQL("drop table if exists admin");
    }

    public Boolean insertData(String fullname, String email, String username, String password)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname", fullname);
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users",null,contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean insertadmin(String fullname, String email, String username, String password)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname", fullname);
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("admin",null,contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public boolean checkadminusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from admin where username = ?", new String[] {username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public boolean checkadminusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from admin where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean insertTrain(String id, String departure, String arrival, String date, String total_seats)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("departure", departure);
        contentValues.put("arrival", arrival);
        contentValues.put("date", date);
        contentValues.put("total_seats", total_seats);
        long result = MyDB.insert("trains",null,contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean updateTrain(String id, String departure, String arrival, String date, String total_seats)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("departure", departure);
        contentValues.put("arrival", arrival);
        contentValues.put("date", date);
        contentValues.put("total_seats", total_seats);
        Cursor cursor = MyDB.rawQuery("Select * from trains where id = ?", new String[] {id});
        if (cursor.getCount()>0){
        long result = MyDB.update("trains", contentValues,"id=?", new String[] {id});
        if(result==-1) return false;
        else
            return true;
        }
        else
            {
                return false;
            }
    }

    public Boolean deleteTrain(String id)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from trains where id = ?", new String[] {id});
        if (cursor.getCount()>0){
            long result = MyDB.delete("trains","id=?", new String[] {id});
            if(result==-1) return false;
            else
                return true;
        }
        else
            {
                return false;
            }
    }

    public Cursor viewTrains()
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from trains", null);
        return cursor;
    }



    public boolean checkid(String id){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from trains where id = ?", new String[] {id});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

















}
