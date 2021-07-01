package com.example.justdoit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class BaseActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navView);

        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0,0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                CharSequence title = item.getTitle();

                if ("Treinos".contentEquals(title)) {
                    Intent intent = new Intent(BaseActivity.this, TreinosActivity.class);
                    startActivity(intent);

                } else if ("Alimentação".contentEquals(title)) {
                    Intent intent2 = new Intent(BaseActivity.this, AlimentacaoActivity.class);
                    startActivity(intent2);

                } else if ("Evolução".contentEquals(title)) {
                    Intent intent3 = new Intent(BaseActivity.this, EvolucaoActivity.class);
                    startActivity(intent3);

                } else if ("Configurações".contentEquals(title)) {
                    Intent intent4 = new Intent(BaseActivity.this, ConfiguracoesActivity.class);
                    startActivity(intent4);

                } else {
                    Toast.makeText(getApplicationContext(), "Click " + item.getTitle(), Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}