package manhntph29583.baithi.lab2_nc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class myBR extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        MyPhoneState1 myPhoneState1 = new MyPhoneState1(context);
        telephonyManager.listen(myPhoneState1, PhoneStateListener.LISTEN_CALL_STATE);
    }
    public class MyPhoneState1 extends PhoneStateListener{
        Context context;
        public MyPhoneState1 (Context context){
            this.context = context;
        }

        @Override
        public void onCallStateChanged(int state, String phoneNumber) {
            super.onCallStateChanged(state, phoneNumber);
            if(state == 1){
                Toast.makeText(context, "Có cuộc gọi đến", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
