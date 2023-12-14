package manhntph29583.baithi.lab2_nc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class myBR2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String duLieu = intent.getStringExtra("br");
        String kq = xuLyChuoi(duLieu);
        Toast.makeText(context, kq, Toast.LENGTH_SHORT).show();
    }
    public String xuLyChuoi(String str){
        if(str.substring(0,3).equals("MEM")){
            if(str.equals("MEM537128")){
                return "Khuyen mai 10%";
            }else if(str.equals("MEM537129")){
                return "Khuyen mai 20%";
            }else{
                return "khuyen mai tu 10-20%";
            }
        }else if(str.substring(0,3).equals("VIP")){
            if(str.equals("VIP537128")){
                return "Khuyen mai 30%";
            }else if(str.equals("VIP537129")){
                return "Khuyen mai 50%";
            }else{
                return "khuyen mai tu 30-50%";
            }
        }else{
            return "khong khuyen mai";
        }
    }
}
