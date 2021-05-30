package com.example.mylangapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void Scan(View view) {
        Intent intent = new Intent(this, ScanActivity.class);
        startActivity(intent);
    }

    public void gaode_Map(View view) {
        Intent intent = new Intent(this, gaode_Map.class);
        startActivity(intent);
    }

    public void gaode_Map_graph(View view) {
        Intent intent = new Intent(this, gaode_Map_graph.class);
        startActivity(intent);
    }

    public void voice_function(View view) {
        Intent intent = new Intent(this, voice_function.class);
        startActivity(intent);
    }


}