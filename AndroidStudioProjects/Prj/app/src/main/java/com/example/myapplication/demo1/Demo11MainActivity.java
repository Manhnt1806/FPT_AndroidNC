package com.example.myapplication.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
public class Demo11MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    EditText txt1,txt2;
    Intent intent1,intent2,intent3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo11_main3);
        btn1=findViewById(R.id.demo1Btn1);
        btn2=findViewById(R.id.demo1Btn2);
        txt1=findViewById(R.id.demo1Txt1);
        txt2=findViewById(R.id.demo1Txt2);
        intent1=new Intent(this,MyService1.class);
        intent2=new Intent(this,MyService2.class);
        intent3=new Intent(this,MyService3.class);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                //truyen du lieu cho service
//                String ma=txt1.getText().toString();
//                String ten=txt2.getText().toString();
//                intent2.putExtra("masv",ma);
//                intent2.putExtra("tensv",ten);
//                startService(intent2);

                //Truyen chuoi
                String check=txt1.getText().toString();
                intent3.putExtra("check",check);
                //truyen ky tu
                String inputChar=txt2.getText().toString();//lay chuoi nguoi dung nhap
                char[] c=inputChar.toCharArray();//bien chuoi thanh mang
                intent3.putExtra("char",c[0]);//dua vao intent
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