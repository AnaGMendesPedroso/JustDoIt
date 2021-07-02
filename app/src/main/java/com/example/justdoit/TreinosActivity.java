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

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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


        ArrayList<TreinoModel> treinos = null;
        try {
            treinos = dbHelper.consultarTodosTreinos();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(treinos.size()!=0){
            for ( TreinoModel t: treinos) {
                listView.setAdapter(new AdaptadorTreino(this,t));
            }

        } else {
            Toast.makeText(getApplicationContext(), "Não há treinos cadastrados", Toast.LENGTH_LONG).show();
            buttonCadastrarTreino.setVisibility(View.VISIBLE);
        }

    }

    public void redirecionarCadastrarTreino(View view){
        Intent intent = new Intent(this, CadastrarTreino.class);
        startActivity(intent);
    }

    public void atualizarTreinos(View view){
        ListView listView = findViewById(R.id.treinoDeHoje);
        Button buttonCadastrarTreino = findViewById(R.id.buttonCadastrarTreino);

        ArrayList<TreinoModel> treinos = null;
        try {
            treinos = dbHelper.consultarTodosTreinos();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(treinos.size()!=0){
            for ( TreinoModel t: treinos) {
                listView.setAdapter(new AdaptadorTreino(this,t));
            }

        } else {
            Toast.makeText(getApplicationContext(), "Não há treinos cadastrados", Toast.LENGTH_LONG).show();
            buttonCadastrarTreino.setVisibility(View.VISIBLE);
        }
    }
}