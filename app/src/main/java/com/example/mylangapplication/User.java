package com.example.mylangapplication;

import android.content.ContentValues;

public class User {
    public int uid;
    public String uname;
    public String upasswd;
    public String utel;
    public String ubirthday;
    public String uemail;

    //get the user information
    public static ContentValues getUserValues(User user){
        ContentValues cv = new ContentValues();
        cv.put("uname", user.uname);
        cv.put("upasswd", user.upasswd);
        cv.put("ubirthday", user.ubirthday);
        cv.put("uemail", user.uemail);
        cv.put("utel", user.utel);
        return cv;
    }





}
