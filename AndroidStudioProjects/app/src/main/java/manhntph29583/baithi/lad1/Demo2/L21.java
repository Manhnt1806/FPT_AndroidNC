package manhntph29583.baithi.lad1.Demo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import manhntph29583.baithi.lad1.R;

public class L21 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l21);
        xinQuyenNguoiDung();
        Intent intent = new Intent(this, myBR1.class);
        sendBroadcast(intent);
    }
    public boolean xinQuyenNguoiDung(){
        if(Build.VERSION.SDK_INT>=23){
            if(checkSelfPermission(Manifest.permission.READ_PHONE_NUMBERS)==
                    PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.READ_PHONE_STATE)==
                    PackageManager.PERMISSION_GRANTED){
                return true;
            }else{
                ActivityCompat.requestPermissions(L21.this, new String[]{
                        Manifest.permission.READ_PHONE_NUMBERS,
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