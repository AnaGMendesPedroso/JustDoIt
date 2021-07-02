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

import androidx.fragment.app.DialogFragment;

import com.example.justdoit.helpers.DBHelper;
import com.example.justdoit.model.TreinoModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CadastrarTreino extends BaseActivity implements DatePickerDialog.OnDateSetListener{
    
    private DBHelper dbHelper = new DBHelper(this);
    private EditText nomeTreino;
    private EditText dataInicio;
    private EditText frequencia;
    private EditText profissional;
    private EditText aquecimento;
    private ImageView imagemTreino;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.activity_cadastrar_treino, null, false);
        drawerLayout.addView(v,0);

        nomeTreino = findViewById(R.id.editTextNomeTreino);
        dataInicio = findViewById(R.id.editTextDataInicio);
        frequencia = findViewById(R.id.editTextFrequencia);
        profissional = findViewById(R.id.editTextResponsavel);
        aquecimento = findViewById(R.id.editTextAquecimento);
        imagemTreino = findViewById(R.id.imageViewTreino);

        dataInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date piker");
            }
        });
    }
    
    public void cadastrarTreino(View view) throws ParseException {

        TreinoModel treinoModel = new TreinoModel(nomeTreino.getText().toString(), simpleDateFormat.format(simpleDateFormat.parse(dataInicio.getText().toString())), Integer.parseInt(frequencia.getText().toString()), profissional.getText().toString(), aquecimento.getText().toString(), imagemTreino.getBaseline());
        dbHelper.criarTreino(treinoModel);

        int idTreino = dbHelper.buscarTreinoId(treinoModel);
        treinoModel.setIdTreino(idTreino);

        Intent intent = new Intent(this, CadastrarExerciciosTreino.class);
        intent.putExtra("treinoId", String.valueOf(idTreino));

        Toast.makeText(getApplicationContext(), "Treino cadastrado com sucesso", Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("pt", "BR")).format(c.getTime());
        dataInicio.setText(currentDateString);
    }
}