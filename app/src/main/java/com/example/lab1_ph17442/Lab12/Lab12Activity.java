package com.example.lab1_ph17442.Lab12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.lab1_ph17442.MainActivity;
import com.example.lab1_ph17442.R;

public class Lab12Activity extends AppCompatActivity {
     public static int TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab12);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Lab12Activity.this,Lab122Activity.class);
                startActivity(intent);
                finish();
            }
        }, TIME_OUT);
    }
}