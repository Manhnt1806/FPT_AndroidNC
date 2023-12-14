package com.example.myapplication.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
public class Demo22MainActivity extends AppCompatActivity {
    Button btn1;
    EditText txt1;
    Context context=this;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo22_main);
        btn1=findViewById(R.id.demo22Btn1);
        txt1=findViewById(R.id.demo22Txt1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=txt1.getText().toString();
                Intent intent=new Intent(context,MyBroadcast2.class);
                intent.putExtra("br",str);
                sendBroadcast(intent);
            }
        });

    }
}