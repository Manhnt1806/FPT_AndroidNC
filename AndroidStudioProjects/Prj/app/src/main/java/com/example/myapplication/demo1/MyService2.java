package com.example.myapplication.demo1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
public class MyService2 extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String ma=intent.getStringExtra("masv");
        String ten=intent.getStringExtra("tensv");
        Toast.makeText(this, "Ma sinh vien: "+ma+
                "; Ten sinh vien: "+ten, Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }
}
