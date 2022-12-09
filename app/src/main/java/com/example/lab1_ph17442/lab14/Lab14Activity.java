package com.example.lab1_ph17442.lab14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab1_ph17442.R;

public class Lab14Activity extends AppCompatActivity implements View.OnClickListener {
   EditText edTime;
   Button btnRun;
   TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab14);
        edTime = findViewById(R.id.edtTOut);
        btnRun = findViewById(R.id.btnAsync);
        tvResult = findViewById(R.id.tvResult);
        btnRun.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
     String sleepTime = edTime.getText().toString();
     new Lab14AsyncTask(this, tvResult,edTime).execute(sleepTime);
    }
}