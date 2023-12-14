package manhntph29583.baithi.myasm_nc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import manhntph29583.baithi.myasm_nc.MainCourse.MainCourse;
import manhntph29583.baithi.myasm_nc.MainNews.MainNews;

public class MainActivity extends AppCompatActivity {
    LinearLayout lnCourse, lnMaps, lnNews, lnSocial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lnCourse = findViewById(R.id.ln_Course);
        lnMaps = findViewById(R.id.ln_Maps);
        lnNews = findViewById(R.id.ln_News);
        lnSocial = findViewById(R.id.ln_Social);
        lnCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, MainCourse.class);
                startActivity(intent);
            }
        });
        lnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        lnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, MainNews.class);
                startActivity(intent);
            }
        });
        lnSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, MainSocial.class);
                startActivity(intent);
            }
        });
    }
}