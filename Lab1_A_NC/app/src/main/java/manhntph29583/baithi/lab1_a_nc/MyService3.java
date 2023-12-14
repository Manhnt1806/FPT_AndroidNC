package manhntph29583.baithi.lab1_a_nc;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService3 extends IntentService {
    public MyService3(){super("MyService3");}
    int count = 0;

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Tổng số ký tự là: "+count, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Hủy service", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        char c1 = intent.getCharExtra("char", '0');
        String str1 = intent.getStringExtra("check");
        count = demKT(str1,c1);
    }

    private int demKT (String str, char c){
        int dem = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==c){
                dem++;
            }
        }
        return dem;
    }
}
