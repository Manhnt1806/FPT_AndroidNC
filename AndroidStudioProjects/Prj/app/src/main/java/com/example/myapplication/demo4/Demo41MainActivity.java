package com.example.myapplication.demo4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.demo2.Demo21MainActivity;

public class Demo41MainActivity extends AppCompatActivity
        implements LocationListener {
    TextView txtLong, txtLat;
    LocationManager locationManager;//doi tuong quan ly location

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo41_main);
        txtLong = findViewById(R.id.demo41Long);
        txtLat = findViewById(R.id.demo41Lat);
        xinQuyenNguoiDung();
        //1. Goi service quan ly location
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        //2. neu co quyen, thi cap nhat vi tri
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1,
                (LocationListener) this);
    }
    public boolean xinQuyenNguoiDung()
    {
        if(Build.VERSION.SDK_INT>=23)//version cao
        {
            //neu quyen read phone state da duoc gan
            //neu quyen read phone number da duoc gan
            if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)==
                    PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)==
                    PackageManager.PERMISSION_GRANTED)
            {
                return true;//nhan duoc quyen
            }
            else //neu chua co quyen thi thong bao nguyoi dung cap quyen
            {
                ActivityCompat.requestPermissions(Demo41MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION},1);
                return false;
            }
        }
        else
        {
            Log.d("Phan quyen","Quyen da duoc gan");
            return true;
        }
    }
//ham lang nghe su thay doi vi tri
    @Override
    public void onLocationChanged(@NonNull Location location) {
        double longti=location.getLongitude();
        double lat=location.getLatitude();
        txtLong.setText("Toa do long: "+String.valueOf(longti));
        txtLat.setText("Toa do Lat: "+String.valueOf(lat));
    }
}