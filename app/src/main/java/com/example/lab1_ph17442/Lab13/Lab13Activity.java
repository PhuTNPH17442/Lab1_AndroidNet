package com.example.lab1_ph17442.Lab13;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab1_ph17442.R;

public class Lab13Activity extends AppCompatActivity implements
        View.OnClickListener, Listener
{
    Button btn3;
    ImageView img3;
    TextView txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn3= findViewById(R.id.btnload);
        img3 = findViewById(R.id.imageView);
        txt3 = findViewById(R.id.tvMes);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      new Lab31AsyncTask(this,this).execute("https://images.app.goo.gl/VPPiTCqE9AJjBaep8");
    }

    @Override
    public void onImageDownLoad(Bitmap bitmap) {
         img3.setImageBitmap(bitmap);
         txt3.setText("DownLoadThanh Cong");
    }

    @Override
    public void onError() {
           txt3.setText("DownLoad That BAi");
    }
}