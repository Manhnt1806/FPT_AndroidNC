package com.example.myapplication.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
public class Demo23MainActivity extends AppCompatActivity
implements MyInter1
{
    Button btn;
    EditText txt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo23_main);
        btn=findViewById(R.id.demo23Btn1);
        txt=findViewById(R.id.demo23Txt1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dulieu=txt.getText().toString();
                Intent intent=new Intent(Demo23MainActivity.this,
                        MyBroadcast3.class);
                //dua du lieu vao intent
                intent.putExtra("br",dulieu);
                //goi broadcast
                sendBroadcast(intent);
            }
        });
    }
    String kq="";
    @Override
    public String getDataCallback(String msg) {
        kq=msg;
        return kq;
    }
}