package com.example.justdoit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.justdoit.helpers.DBHelper;
import com.example.justdoit.model.ExercicioModel;
import com.example.justdoit.model.TreinoModel;

public class CadastrarExerciciosTreino extends BaseActivity {
    private DBHelper dbHelper = new DBHelper(this);
    private EditText nomeExercicio;
    private EditText ordem;
    private EditText series;
    private EditText qtdRepeticoes;
    private EditText carga;
    private EditText observacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.activity_cadastrar_exercicios_treino, null, false);
        drawerLayout.addView(v,0);

        nomeExercicio = findViewById(R.id.editTextNomeExercicio);
        ordem = findViewById(R.id.editTextOrdem);
        series = findViewById(R.id.editTextSeries);
        qtdRepeticoes = findViewById(R.id.editTextQtdRepeticoes);
        carga = findViewById(R.id.editTextCarga);
        observacoes = findViewById(R.id.editTextObservacoes);
    }

    public void cadastrarExercicio(View view){

        ExercicioModel exercicioModel = new ExercicioModel(nomeExercicio.getText().toString(), Integer.parseInt(ordem.getText().toString()), Integer.parseInt(series.getText().toString()), Integer.parseInt(qtdRepeticoes.getText().toString()), Float.parseFloat(carga.getText().toString()), observacoes.getText().toString());
        dbHelper.criarExercicio(exercicioModel);
        int idExercicio = dbHelper.buscarExercicioId(exercicioModel);
        exercicioModel.setIdExercicio(idExercicio);

        Intent intent = getIntent();

        int treinoId = Integer.parseInt(intent.getStringExtra("treinoId"));

        TreinoModel treinoModel = dbHelper.buscarTreinoPorId(treinoId);
        dbHelper.vincularExercicioTreino(treinoModel, exercicioModel);

        Toast.makeText(getApplicationContext(), "Exercício cadastrado com sucesso", Toast.LENGTH_LONG).show();
        nomeExercicio.setText("");
        ordem.setText("");
        series.setText("");
        qtdRepeticoes.setText("");
        carga.setText("");
        observacoes.setText("");
        Toast.makeText(getApplicationContext(), "Cadastre o próximo exercício do treino ou finalize o cadastro", Toast.LENGTH_LONG).show();
    }

    public void finalizarCadastrarExercicio(View v){
        finish();
    }
}