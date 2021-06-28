package com.example.justdoit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class ConteudoWebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo_web);

        Intent intent = getIntent();

        String url = intent.getStringExtra("url");

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl(url);

    }
}