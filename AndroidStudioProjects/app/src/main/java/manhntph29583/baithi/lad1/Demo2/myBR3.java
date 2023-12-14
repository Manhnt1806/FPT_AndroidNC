package manhntph29583.baithi.lad1.Demo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class myBR3 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String data = intent.getStringExtra("br");//Nhận thông tin
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show();//phát lại thông điệp
    }
}
