package com.example.lab1_ph17442.Lab13;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.net.URL;

public class Lab31AsyncTask extends AsyncTask<String, Void, Bitmap> {
    Listener mlListener;
    ProgressDialog progressDialog;


    public  Lab31AsyncTask(Listener listener, Context context)
    {
        this.mlListener = listener;
        this.progressDialog = new ProgressDialog(context);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("bat dau download");
        progressDialog.show();
    }
    Bitmap bitmap = null;
    @Override
    protected Bitmap doInBackground(String... strings) {
        URL url;

        try {
            url = new URL(strings[0]);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        if(bitmap!= null)
        {
            mlListener.onImageDownLoad(bitmap);
        }else {
            mlListener.onError();
        }
    }
}
