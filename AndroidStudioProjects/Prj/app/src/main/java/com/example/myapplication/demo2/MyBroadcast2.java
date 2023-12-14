package com.example.myapplication.demo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcast2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String data=intent.getStringExtra("br");//nhan thong diep
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show();//phat lai thong diep
    }
}
