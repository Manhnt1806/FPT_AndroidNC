package manhntph29583.baithi.lab2_nc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xinQuyenNguoiDung();
        Intent intent = new Intent(this, myBR.class);
        sendBroadcast(intent);
    }
    public boolean xinQuyenNguoiDung(){
        if(Build.VERSION.SDK_INT>=23){
            if(checkSelfPermission(android.Manifest.permission.READ_PHONE_NUMBERS)==
                    PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(android.Manifest.permission.READ_PHONE_STATE)==
                    PackageManager.PERMISSION_GRANTED){
                return true;
            }else{
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                        android.Manifest.permission.READ_PHONE_NUMBERS,
                        Manifest.permission.READ_PHONE_STATE
                }, 1);
                return false;
            }
        }else{
            Log.d("Xin quyen", "Quyen da duoc cap");
            return false;
        }
    }
}