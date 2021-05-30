package com.example.mylangapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText mMobileEt;
    EditText mPwdEt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mMobileEt = findViewById(R.id.mMobileEt);
        mPwdEt = findViewById(R.id.mPwdEt);
    }



    //check the name and password
    public boolean login(String name, String pwd) {
        int id = DBDao.getInstance(this).userLogin(name, pwd);
        if (id != -1) {
//            getSharedPreferences("user",MODE_PRIVATE).edit().putInt("id",id).commit();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            return true;
//            finish();

        } else {
            Toast.makeText(LoginActivity.this, "fail", Toast.LENGTH_SHORT).show();
            return false;
        }

    }




    //base error checking
    public void btnOnClick(View view) {
        String name = mMobileEt.getText().toString();
        String pwd = mPwdEt.getText().toString();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(LoginActivity.this, "User cannot empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(LoginActivity.this, "Password cannot empty", Toast.LENGTH_SHORT).show();
            return;
        }

        login(name, pwd);
    }


    //go to the register page
    public void register(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
}