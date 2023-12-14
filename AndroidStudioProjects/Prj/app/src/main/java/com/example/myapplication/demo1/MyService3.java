package com.example.myapplication.demo1;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;
public class MyService3 extends IntentService {
    public MyService3() {
        super("MyService3");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Tong so ky tu la: "+count, Toast.LENGTH_SHORT).show();
    }
    int count=0;
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //lay ve ky tu
        char c1=intent.getCharExtra("char",'0');
        //lay ve chuoi
        String str1=intent.getStringExtra("check");
        count=demKyTu(str1,c1);//goi ham dem ky tu
    }
    private int demKyTu(String str,char c)
    {
        int dem=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==c)//neu ky tu tai vi tri i bang c
            {
                dem++;
            }
        }
        return dem;
    }
}
