package manhntph29583.baithi.lad1.demo1;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService3 extends IntentService {

    public MyService3() {
        super("MyService3");
    }
    int count = 0;

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Tong so kt la: "+count, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "huy service", Toast.LENGTH_SHORT).show();

        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //Lấy về ký tự
        char c1 = intent.getCharExtra("char", '0');
        String str1 = intent.getStringExtra("check");
        count = demKT(str1,c1);//gọi hàm đếm ký tự
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
