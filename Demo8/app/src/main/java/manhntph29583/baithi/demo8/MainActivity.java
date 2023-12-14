package manhntph29583.baithi.demo8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Camera.getNumberOfCameras();
                if(num>0){
                    Toast.makeText(getApplicationContext(), "Coù"+num, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent()
                }
            }
        });

    }
    public boolean xinQuyenNguoiDung(){
        if(Build.VERSION.SDK_INT>=23){
            if(checkSelfPermission(Manifest.permission.))
        }
    }
}