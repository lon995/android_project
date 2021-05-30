package com.example.mylangapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "game.db";


    private static final int DATABASE_VERSION = 1;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //create the user account
    @Override
    public void onCreate(SQLiteDatabase db) {

        String user = "create table user ("
                + "uid integer primary key autoincrement, "
                + "uname VARCHAR, "
                + "upasswd VARCHAR, "
                + "utel VARCHAR, "
                + "ubirthday VARCHAR, "
                + "uemail VARCHAR)";
        String student = "create table student ("
                + "id integer primary key autoincrement, "
                + "name VARCHAR, "
                + "code VARCHAR, "
                + "tel VARCHAR, "
                + "gradleId integer, "
                + "des VARCHAR)";
        String gradle = "create table gradle ("
                + "id integer primary key autoincrement, "
                + "name VARCHAR)";
        db.execSQL(user);
        db.execSQL(student);
        db.execSQL(gradle);
    }

    //for update user information
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
