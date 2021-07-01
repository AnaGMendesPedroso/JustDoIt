package com.example.justdoit;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.justdoit.R;
import com.example.justdoit.adapters.AdaptadorTreino;
import com.example.justdoit.helpers.DBHelper;
import com.example.justdoit.model.TreinoModel;
import com.google.android.material.navigation.NavigationView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class TreinosActivity extends BaseActivity {

    private  DBHelper dbHelper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.activity_treinos, null, false);
        drawerLayout.addView(v,0);

        ListView listView = findViewById(R.id.treinoDeHoje);
        Button buttonCadastrarTreino = findViewById(R.id.buttonCadastrarTreino);

        LocalDate hoje = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            hoje = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String hojeFormatado = hoje.format(formatter);
            TreinoModel treinoHoje = dbHelper.consultarTreinoHoje(hojeFormatado);

            if(treinoHoje.getNomeTreino() != null){

                listView.setAdapter(new AdaptadorTreino(this,treinoHoje));

            } else {
                dbHelper.removerTreino(1);
                dbHelper.removerTreino(2);
                dbHelper.removerTreino(3);
                dbHelper.removerTreino(4);
                dbHelper.removerTreino(5);
                dbHelper.removerTreino(6);
                dbHelper.removerTreino(7);
                dbHelper.removerTreino(8);
                dbHelper.removerTreino(9);
                Toast.makeText(getApplicationContext(), "Não há treinos cadastrados", Toast.LENGTH_LONG).show();
                buttonCadastrarTreino.setVisibility(View.VISIBLE);
            }
        }
    }

    public void redirecionarCadastrarTreino(View view){
        Intent intent = new Intent(this, CadastrarTreino.class);
        startActivity(intent);
    }
}