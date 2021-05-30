package com.example.mylangapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class DBDao {

    private static DBDao userDB;

    private SQLiteDatabase db;


    private DBDao(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public static DBDao getInstance(Context context) {
        if (userDB == null) {
            userDB = new DBDao(context);
        }
        return userDB;
    }

    //for update user information
    public   User updateUser(int id,String name,String email,String tel, String birth){
        User user = null;
        if (id != 0) {
            ContentValues cv = new ContentValues();
            cv.put("uid",id);
            cv.put("uname",name);
            cv.put("uemail",email);
            cv.put("utel",tel);
            cv.put("ubirthday",birth);
            //update database
          db.update("user",cv,"uid"+"="+id, null) ;




            Cursor cursor = db .query("user", null, "uid"+"="+id, null, null, null, null);
            if(cursor!=null){
                if(cursor.getCount()>0){
                    cursor.moveToFirst();
                    String uname  = cursor.getString(cursor.getColumnIndex("uname"));
                    String upasswd  = cursor.getString(cursor.getColumnIndex("upasswd"));
                    String utel  = cursor.getString(cursor.getColumnIndex("utel"));
                    String ubirthday  = cursor.getString(cursor.getColumnIndex("ubirthday"));
                    String uemail  = cursor.getString(cursor.getColumnIndex("uemail"));
                    user = new User();
                    user.uid = id;
                    user.uname = uname;
                    user.upasswd = upasswd;
                    user.utel = utel;
                    user.ubirthday = ubirthday;
                    user.uemail = uemail;
                }
                cursor.close();
            }


        }
        return user;

    }


    //be a register
    public boolean  registerUser(User user) {
        if (user != null) {
            Cursor cursor = db .query("user", null, "uname=?", new String[]{user.uname}, null, null, null);
            if (cursor.getCount() > 0) {
                return false;
            } else {
                db.insert("user",null,User.getUserValues(user));
                return true;
            }
        }
        return false;

    }

    //get the user information
    public User getUserInfoById(int id) {
        User user = null;
        Cursor cursor = db .query("user", null, "uid"+"="+id, null, null, null, null);
        if(cursor!=null){
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                String uname  = cursor.getString(cursor.getColumnIndex("uname"));
                String upasswd  = cursor.getString(cursor.getColumnIndex("upasswd"));
                String utel  = cursor.getString(cursor.getColumnIndex("utel"));
                String ubirthday  = cursor.getString(cursor.getColumnIndex("ubirthday"));
                String uemail  = cursor.getString(cursor.getColumnIndex("uemail"));
                user = new User();
                user.uid = id;
                user.uname = uname;
                user.upasswd = upasswd;
                user.utel = utel;
                user.ubirthday = ubirthday;
                user.uemail = uemail;
            }
            cursor.close();
        }
        return user;
    }

    //check the password and username is match?
    public int userLogin(String name , String password){
        Cursor cursor = db .query("user", null, "uname=?"+" and "+"upasswd=?", new String[]{name,password}, null, null, null);
        if (cursor.getCount()>0){
            cursor.moveToNext();
            return cursor.getInt(cursor.getColumnIndex("uid"));
        }else {
            return -1;
        }
    }



}
