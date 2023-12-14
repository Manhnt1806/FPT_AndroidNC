package manhntph29583.baithi.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgh, imgM, imgS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgh = findViewById(R.id.imageView);
        imgM = findViewById(R.id.imageView2);
        imgS = findViewById(R.id.imageView3);
        run();
    }
    private void run(){
        Animation aniH = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.demo7_hour);
        imgh.startAnimation(aniH);
        Animation aniM = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.demo7_min);
        imgM.startAnimation(aniM);
        Animation aniS = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.demo7_sec);
        imgS.startAnimation(aniS);
    }
}