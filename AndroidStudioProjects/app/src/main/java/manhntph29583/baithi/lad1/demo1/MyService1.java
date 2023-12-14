package manhntph29583.baithi.lad1.demo1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService1 extends Service {
    //Gắn với 1 intent
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Ham destroy duoc goi", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Ham onCreate duoc goi", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Ham onStartCommand duoc goi", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }
}
