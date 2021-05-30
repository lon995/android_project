package com.example.mylangapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;


import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;



public class RegisterActivity extends AppCompatActivity {

    EditText etWriteName;
    EditText etPhone;
    EditText etWritePwd;
    EditText etEmail;
    private EditText etBirthday;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etWriteName = findViewById(R.id.et_write_name);
        etWritePwd = findViewById(R.id.et_write_pwd);
        etPhone = findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
        etBirthday = findViewById(R.id.et_birthday);
    }



    public void showToast(String msg) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }

    //register hins for be a register
    public void register(View view) {
        String name = etWriteName.getText().toString();
        String phone = etPhone.getText().toString();
        String pwd = etWritePwd.getText().toString();
        String birthday = etBirthday.getText().toString();
        String email = etEmail.getText().toString();
        if (TextUtils.isEmpty(name)) {
            showToast("Please input the username");
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            showToast("Please input the password");
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            showToast("Please input the phone number");
            return;
        }
        if (TextUtils.isEmpty(birthday)) {
            showToast("Please input the birthday");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            showToast("Please input the email");
            return;
        }
        User user = new  User() ;
        user.uname = name;
        user.uemail = email;
        user.upasswd = pwd;
        user.utel = phone;
        user.ubirthday = birthday;


        if (DBDao.getInstance(this).registerUser(user)){
            showToast("succes");
            finish();
        }else{
            showToast("fail");
        }
    }

    //back the login page
    public void back(View view) {
        finish();
    }
}
