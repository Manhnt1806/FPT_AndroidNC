package com.example.myapplication.demo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcast3 extends BroadcastReceiver {
    MyInter1 myInter1;
    String kq="";

    @Override
    public void onReceive(Context context, Intent intent) {
    //Nhan du lieu chuyen den
        String msg=intent.getStringExtra("br");
        //goi ham xu ly
        kq=xuLyChuoi(msg);
        //dua ra thong bao
        myInter1=new Demo23MainActivity();
        myInter1.getDataCallback(kq);
        Toast.makeText(context, kq, Toast.LENGTH_SHORT).show();
    }
    private String xuLyChuoi(String str)
    {
        if(str.substring(0,3).equals("MEM"))
        {
            if(str.equals("MEM537128"))
            {
                return "Khuyen mai 10%";
            }
            else if(str.equals("MEM537129"))
            {
                return "Khuyen mai 20%";
            }
            else
            {
                return "Khuyen mai 10% den 20%";
            }
        }
        else if(str.substring(0,3).equals("VIP"))
        {
            if(str.equals("VIP537128"))
            {
                return "Khuyen mai 30%";
            }
            else if(str.equals("VIP537129"))
            {
                return "Khuyen mai 50%";
            }
            else
            {
                return "Khuyen mai 30% den 50%";
            }
        }
        else
        {
            return "Khong khuyen mai";
        }
    }
}
