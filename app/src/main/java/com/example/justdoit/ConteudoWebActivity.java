package com.example.justdoit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;

public class ConteudoWebActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.activity_conteudo_web, null, false);
        drawerLayout.addView(v,0);

        Intent intent = getIntent();

        String url = intent.getStringExtra("url");

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl(url);

    }
}