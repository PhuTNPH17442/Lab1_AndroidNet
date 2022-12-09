package com.example.lab1_ph17442.lab14;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

public class Lab14AsyncTask extends AsyncTask <String,Void,String> {
    private ProgressDialog progressDialog;
    TextView tvResult;
    EditText txtTime;
    Context context;
    String kq;
    public Lab14AsyncTask (Context context ,TextView tvResult, EditText txtTime){
        this.context = context;
        this.tvResult = tvResult;
        this.txtTime = txtTime;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context,"Title","Xin doi"+txtTime.getText().toString()+"giay");
    }

    @Override
    protected String doInBackground(String... strings) {
//        publishProgress("Sleeping....");
        try {
            int time = Integer.parseInt(strings[0])+1000;
            Thread.sleep(time);
            kq = "Da sleep trong"+strings[0]+"giay";
        }catch (Exception e){
            e.printStackTrace();
            kq = e.getMessage();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        tvResult.setText(s);
    }
}
