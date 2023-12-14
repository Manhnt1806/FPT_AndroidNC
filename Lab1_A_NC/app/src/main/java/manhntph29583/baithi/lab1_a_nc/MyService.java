package manhntph29583.baithi.lab1_a_nc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Ham onStartCommand duoc goi", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Ham onCreate duoc goi", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Ham destroy duoc goi", Toast.LENGTH_SHORT).show();
    }
}
