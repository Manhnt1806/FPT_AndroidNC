package manhntph29583.baithi.lad1.demo4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import manhntph29583.baithi.lad1.Demo2.L21;
import manhntph29583.baithi.lad1.R;

public class Demo4_Activity extends AppCompatActivity implements LocationListener {
    LocationManager locationManager;
    TextView txt1, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        xinQuyenNguoiDung();
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, (LocationListener) this);
    }
    public boolean xinQuyenNguoiDung(){
        if(Build.VERSION.SDK_INT>=23){
            if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)==
                    PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)==
                    PackageManager.PERMISSION_GRANTED){
                return true;
            }else{
                ActivityCompat.requestPermissions(Demo4_Activity.this, new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                }, 1);
                return false;
            }
        }else{
            Log.d("Xin quyen", "Quyen da duoc cap");
            return false;
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        double longti = location.getLongitude();
        double lat = location.getLatitude();
        txt1.setText("Toa do long: "+ String.valueOf(longti));
        txt2.setText("Toa do lat: "+ String.valueOf(lat));
    }
}