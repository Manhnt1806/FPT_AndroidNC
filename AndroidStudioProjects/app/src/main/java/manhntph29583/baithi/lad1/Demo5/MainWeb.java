package manhntph29583.baithi.lad1.Demo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.WeakHashMap;

import manhntph29583.baithi.lad1.R;

public class MainWeb extends AppCompatActivity {
    WebView webView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web);
        webView = findViewById(R.id.webview);
        intent = getIntent();
        String link = intent.getStringExtra("linksent");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
    }
}