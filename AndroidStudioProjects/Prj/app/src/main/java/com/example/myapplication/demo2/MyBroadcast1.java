package com.example.myapplication.demo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyBroadcast1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //goi service lang ngh cuoc goi
        TelephonyManager telephonyManager
                =(TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        //tao object
        MyPhoneState myPhoneState=new MyPhoneState(context);
        //goi phuong thuc lang nghe(ai lang nghe, lang nghe cai gi)
        telephonyManager.listen(myPhoneState,PhoneStateListener.LISTEN_CALL_STATE);
    }
    //Xay dung lop lang nghe cuoc goi den
    public class MyPhoneState extends PhoneStateListener{
        Context context;
        public MyPhoneState(Context context) {
            this.context=context;
        }
        //phuong thuc lang nghe cuoc goi den
        @Override
        public void onCallStateChanged(int state, String phoneNumber) {
            if(state==1)//khi co cuoc goi den
            {
                Toast.makeText(context, "Co cuoc goi den", Toast.LENGTH_SHORT).show();
            }
            super.onCallStateChanged(state, phoneNumber);
        }
    }
}
