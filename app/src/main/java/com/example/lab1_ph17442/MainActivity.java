package com.example.lab1_ph17442;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnload);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.tvMes);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final  Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final  Bitmap bitmap = getPicture("https://images.app.goo.gl/VPPiTCqE9AJjBaep8");

                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                        textView.setText("Image Dowloaded");
                    }
                });
            }
        });
        myThread.start();
    }


    private Bitmap getPicture(String link){
        URL url;
        Bitmap bitmap = null;
        try {
            url = new URL(link);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}