package com.example.justdoit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class ConfiguracoesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.activity_configuracoes, null, false);
        drawerLayout.addView(v,0);
    }
}