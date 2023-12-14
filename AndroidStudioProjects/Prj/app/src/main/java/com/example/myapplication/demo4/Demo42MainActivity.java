package com.example.myapplication.demo4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.R;
public class Demo42MainActivity extends AppCompatActivity {
    TextView txt;
    ConnectivityManager connectivityManager;//doi tuong quan ly ket noi
    NetworkInfo myWifi, my4G;//thong tin mang
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo42_main);
        txt=findViewById(R.id.demo42Txt1);
        xinQuyenNguoiDung();
        //1. goi service
        connectivityManager=(ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        //2. Xac dinh loai ket noi
        myWifi=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        my4G=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if(myWifi.isAvailable() && myWifi.isConnected())
        {
            txt.setText(myWifi.getTypeName());
        }
        if(my4G.isAvailable() && my4G.isConnected())
        {
            txt.setText(my4G.getExtraInfo());
        }
    }
    public boolean xinQuyenNguoiDung()
    {
        if(Build.VERSION.SDK_INT>=23)//version cao
        {
            //neu quyen read phone state da duoc gan
            //neu quyen read phone number da duoc gan
            if(checkSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE)==
                    PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.INTERNET)==
                    PackageManager.PERMISSION_GRANTED)
            {
                return true;//nhan duoc quyen
            }
            else //neu chua co quyen thi thong bao nguyoi dung cap quyen
            {
                ActivityCompat.requestPermissions(Demo42MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_NETWORK_STATE,
                                Manifest.permission.INTERNET},1);
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