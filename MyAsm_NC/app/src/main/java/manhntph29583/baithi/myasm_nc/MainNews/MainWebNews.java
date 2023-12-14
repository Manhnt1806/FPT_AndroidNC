package manhntph29583.baithi.myasm_nc.MainNews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import manhntph29583.baithi.myasm_nc.R;

public class MainWebNews extends AppCompatActivity {
    WebView wv;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web_news);
        wv = findViewById(R.id.wv);
        intent = getIntent();
        String link =intent.getStringExtra("linksent");
        wv.loadUrl(link);
        wv.setWebViewClient(new WebViewClient());
    }
}