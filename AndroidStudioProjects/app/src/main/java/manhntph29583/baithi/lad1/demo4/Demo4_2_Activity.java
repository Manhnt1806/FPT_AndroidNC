package manhntph29583.baithi.lad1.demo4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import manhntph29583.baithi.lad1.R;

public class Demo4_2_Activity extends AppCompatActivity implements LocationListener {
    ConnectivityManager connectivityManager;
    NetworkInfo myWifi, my4G;
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        txt1 = findViewById(R.id.txt1);
        xinQuyenNguoiDung();
        connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        myWifi = connectivityManager.getNetworkInfo(connectivityManager.TYPE_WIFI);
        my4G = connectivityManager.getNetworkInfo(connectivityManager.TYPE_MOBILE);
        if(myWifi.isAvailable() && myWifi.isConnected()){
            txt1.setText("Bạn đang dung "+ myWifi.getTypeName());
        }
        if(my4G.isAvailable() && my4G.isConnected()){
            txt1.setText("Bạn đang dung "+ my4G.getTypeName());
        }

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }
    public boolean xinQuyenNguoiDung(){
        if(Build.VERSION.SDK_INT>=23){
            if(checkSelfPermission(Manifest.permission.INTERNET)==
                    PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE)==
                    PackageManager.PERMISSION_GRANTED){
                return true;
            }else{
                ActivityCompat.requestPermissions(Demo4_2_Activity.this, new String[]{
                        Manifest.permission.ACCESS_NETWORK_STATE,
                        Manifest.permission.ACCESS_NETWORK_STATE
                }, 1);
                return false;
            }
        }else{
            Log.d("Xin quyen", "Quyen da duoc cap");
            return false;
        }
    }
}