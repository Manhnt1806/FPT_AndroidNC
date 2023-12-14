package manhntph29583.baithi.lad1.Demo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class myBR1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Gọi service lắng nghe
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        //Tạo đối tượng chuyển trạng thái
        MyPhoneState1 myPhoneState1 = new MyPhoneState1(context);
        //Bắt đầu lắng nghe .listen(đối tượng, sự kiện)
        telephonyManager.listen(myPhoneState1, PhoneStateListener.LISTEN_CALL_STATE);
    }
    //định nghĩa thữ hiện chuyển trạng thái cho service
    public class MyPhoneState1 extends PhoneStateListener {
        Context context;
        public MyPhoneState1(Context context){
            this.context = context;
        }
    //Chuyển trạng thái
        @Override
        public void onCallStateChanged(int state, String phoneNumber) {
            super.onCallStateChanged(state, phoneNumber);
            if(state == 1){ //Có cuộc gọi đến
                Toast.makeText(context, "Có cuộc gọi đến", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
