package com.example.myapplication.demo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;
public class Demo21MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo21_main);
        xinQuyenNguoiDung();
        Intent intent=new Intent(this,MyBroadcast1.class);
        sendBroadcast(intent);
    }
    public boolean xinQuyenNguoiDung()
    {
        if(Build.VERSION.SDK_INT>=23)//version cao
        {
            //neu quyen read phone state da duoc gan
            //neu quyen read phone number da duoc gan
            if(checkSelfPermission(Manifest.permission.READ_PHONE_STATE)==
                    PackageManager.PERMISSION_GRANTED
            && checkSelfPermission(Manifest.permission.READ_PHONE_NUMBERS)==
            PackageManager.PERMISSION_GRANTED)
            {
                return true;//nhan duoc quyen
            }
            else //neu chua co quyen thi thong bao nguyoi dung cap quyen
            {
                ActivityCompat.requestPermissions(Demo21MainActivity.this,
                        new String[]{Manifest.permission.READ_PHONE_NUMBERS,
                        Manifest.permission.READ_PHONE_STATE},1);
                return false;
            }
        }
        else
        {
            Log.d("Phan quyen","Quyen da duoc gan");
            return true;
        }
    }
}