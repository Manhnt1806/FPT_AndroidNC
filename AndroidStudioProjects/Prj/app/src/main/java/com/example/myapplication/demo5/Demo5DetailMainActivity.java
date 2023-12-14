package com.example.myapplication.demo5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myapplication.R;
public class Demo5DetailMainActivity extends AppCompatActivity {
    WebView webView;
    Intent intent;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5_detail_main);
        webView=findViewById(R.id.demo5Webview);
        intent=getIntent();//lay ve intent chuyen den
        String link=intent.getStringExtra("linksent");//lay duong link
        webView.loadUrl(link);//load du lieu
        webView.setWebViewClient(new WebViewClient());//hien thi
    }
}