package com.app.android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class UrlPage extends AppCompatActivity {

    private WebView web;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_page);
        String url = getIntent().getStringExtra("url");
        if(!url.equals("https://")){
            url = "https://" + url;
        }

        web = findViewById(R.id.WebView);
        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);
        web.loadUrl(url);
        web.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack()){
            web.canGoBack();
        }else{
            super.onBackPressed();
        }
    }
}