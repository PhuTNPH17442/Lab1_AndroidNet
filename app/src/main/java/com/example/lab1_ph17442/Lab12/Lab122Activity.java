package com.example.lab1_ph17442.Lab12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab1_ph17442.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Lab122Activity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private Button btnLoad1;
    private String url="https://images.app.goo.gl/VPPiTCqE9AJjBaep8";
    private Bitmap bitmap = null;
    private TextView tvmessage;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab122);
        imageView = findViewById(R.id.imgLab122);
        btnLoad1 = findViewById(R.id.btnload1);
        tvmessage = findViewById(R.id.tvMessage);
        btnLoad1.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
       progressDialog = ProgressDialog.show(Lab122Activity.this,"Dang download","Dang downLod");
       Runnable runnable = new Runnable() {
           @Override
           public void run() {
                bitmap = downloadBitmap(url);
                Message msg = messageHandler.obtainMessage();
                Bundle bundle = new Bundle();
                String thMessage = "Da download xong ";
                bundle.putString("message",thMessage);
                msg.setData(bundle);
                messageHandler.sendMessage(msg);
           }
       };
       Thread th = new Thread();
       th.start();
    }
    private Handler messageHandler = new Handler(){
        public void handlerMessage(Message msg){
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String message = bundle.getString("message");
            tvmessage.setText(message);
            imageView.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };
    private  Bitmap downloadBitmap(String link){
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}