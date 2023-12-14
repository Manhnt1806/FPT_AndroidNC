package manhntph29583.baithi.lab4_nc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainB2 extends AppCompatActivity implements LocationListener {
    ConnectivityManager connectivityManager;
    NetworkInfo myWifi, my4G;
    TextView internet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b2);
        internet = findViewById(R.id.txt_internet);
        xinQuyenNguoiDung();
        connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        myWifi = connectivityManager.getNetworkInfo(connectivityManager.TYPE_WIFI);
        my4G = connectivityManager.getNetworkInfo(connectivityManager.TYPE_MOBILE);
        if(myWifi.isAvailable() && myWifi.isConnected()){
            internet.setText("Bạn đang dung "+ myWifi.getTypeName());
        }
        if(my4G.isAvailable() && my4G.isConnected()){
            internet.setText("Bạn đang dung "+ my4G.getTypeName());
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }
    public boolean xinQuyenNguoiDung(){
        if(Build.VERSION.SDK_INT>=23){
            if(checkSelfPermission(android.Manifest.permission.INTERNET)==
                    PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)==
                    PackageManager.PERMISSION_GRANTED){
                return true;
            }else{
                ActivityCompat.requestPermissions(MainB2.this, new String[]{
                        android.Manifest.permission.ACCESS_NETWORK_STATE,
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