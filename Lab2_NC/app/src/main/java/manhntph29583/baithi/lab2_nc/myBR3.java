package manhntph29583.baithi.lab2_nc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class myBR3 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String data = intent.getStringExtra("br");
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
    }
}
