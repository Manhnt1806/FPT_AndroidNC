package manhntph29583.baithi.lad1.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import manhntph29583.baithi.lad1.R;

public class Demo1 extends AppCompatActivity {
    Button btn1, btn2;
    EditText txt1, txt2;
    Intent intent1, intent2, intent3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        txt1 = findViewById(R.id.textView);
        txt2 = findViewById(R.id.textView2);
        intent1 = new Intent(this, MyService1.class);
        intent2 = new Intent(this, MyService2.class);
        intent3 = new Intent(this, MyService3.class);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Truyền dữ liệu
//                String ma = txt1.getText().toString();
//                String ten = txt2.getText().toString();
//                intent2.putExtra("masv", ma);
//                intent2.putExtra("tensv", ten);

                //Truyền chuỗi
                String check = txt1.getText().toString();
                intent3.putExtra("check", check);
                //Truyền ký tự
                String inputChar = txt2.getText().toString();
                char[] c = inputChar.toCharArray();
                intent3.putExtra("char", c[0]);
                startService(intent3);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent3);
            }
        });
    }
}