package manhntph29583.baithi.lab1_a_nc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnKT, btnDung, btnShow, btnStop, btnDem, btnDungDem;
    EditText ma, ten, dem, dem2;
    Intent intent, intent2, intent3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKT = findViewById(R.id.btn_KT_Service);
        btnDung = findViewById(R.id.btn_D_Service);
        ma = findViewById(R.id.edt_ma);
        ten = findViewById(R.id.edt_ten);
        btnShow = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
        dem = findViewById(R.id.edt_dem);
//        dem2 = findViewById(R.id.edt_dem2);
        btnDem = findViewById(R.id.btn_dem);
        btnDungDem = findViewById(R.id.btn_dung_dem);

        intent = new Intent(this, MyService.class);
        intent2 = new Intent(this, MyService2.class);
        intent3 = new Intent(this, MyService3.class);

        btnKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });
        btnDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtMa = ma.getText().toString();
                String txtTen = ten.getText().toString();
                intent2.putExtra("Ma", txtMa);
                intent2.putExtra("Ten", txtTen);
                startService(intent2);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent2);
            }
        });
        btnDem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputChar = dem.getText().toString();
                char[] c = inputChar.toCharArray();
                intent3.putExtra("char", c[0]);
                String check = dem.getText().toString();
                intent3.putExtra("check", check);
                startService(intent3);
            }
        });
        btnDungDem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent3);
            }
        });
    }
}