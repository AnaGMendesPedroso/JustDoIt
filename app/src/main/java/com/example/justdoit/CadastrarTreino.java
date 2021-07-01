package com.example.justdoit;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.justdoit.helpers.DBHelper;
import com.example.justdoit.model.TreinoModel;

import java.util.Calendar;

public class CadastrarTreino extends BaseActivity {
    
    private DBHelper dbHelper = new DBHelper(this);
    private EditText nomeTreino;
    private EditText dataInicio;
    private EditText dataReavaliacao;
    private EditText frequencia;
    private EditText profissional;
    private EditText aquecimento;
    private ImageView imagemTreino;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.activity_cadastrar_treino, null, false);
        drawerLayout.addView(v,0);

        nomeTreino = findViewById(R.id.editTextNomeTreino);
        dataInicio = findViewById(R.id.editTextDataInicio);
        dataReavaliacao = findViewById(R.id.editTextDataReavaliacao);
        frequencia = findViewById(R.id.editTextFrequencia);
        profissional = findViewById(R.id.editTextResponsavel);
        aquecimento = findViewById(R.id.editTextAquecimento);
        imagemTreino = findViewById(R.id.imageViewTreino);
        
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        dataInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        CadastrarTreino.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        dataInicio.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        dataReavaliacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        CadastrarTreino.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        dataReavaliacao.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    }
    
    public void cadastrarTreino(View view){
        TreinoModel treinoModel = new TreinoModel(nomeTreino.getText().toString(), dataInicio.getText().toString(), dataReavaliacao.getText().toString(), Integer.parseInt(frequencia.getText().toString()), profissional.getText().toString(), aquecimento.getText().toString(), imagemTreino.getBaseline());
        dbHelper.criarTreino(treinoModel);

        int idTreino = dbHelper.buscarTreinoId(treinoModel);
        treinoModel.setIdTreino(idTreino);

        Intent intent = new Intent(this, CadastrarExerciciosTreino.class);
        intent.putExtra("treinoId", String.valueOf(idTreino));

        Toast.makeText(getApplicationContext(), "Treino cadastrado com sucesso", Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}