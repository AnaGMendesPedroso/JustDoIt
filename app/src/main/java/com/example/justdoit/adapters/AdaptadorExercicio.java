package com.example.justdoit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.justdoit.R;
import com.example.justdoit.model.ExercicioModel;

import java.util.ArrayList;

public class AdaptadorExercicio extends BaseAdapter {
    private ExercicioModel exercicioTreino;
    private Context contexto;

    public AdaptadorExercicio(Context contexto, ExercicioModel exerciciosTreino) {
    this.contexto = contexto;
    this.exercicioTreino = exerciciosTreino;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return exercicioTreino;
    }

    @Override
    public long getItemId(int position) {
        return exercicioTreino.getIdExercicio();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)contexto.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemLista = layoutInflater.inflate(R.layout.item_exercicio, parent, false);

        TextView exercicio = itemLista.findViewById(R.id.nomeExercicio);
        TextView ordem = itemLista.findViewById(R.id.ordemExercicio);
        TextView series = itemLista.findViewById(R.id.qtdSeriesExercicio);
        TextView qtdRepeticoes = itemLista.findViewById(R.id.qtdRepeticoesExercicio);
        TextView carga = itemLista.findViewById(R.id.cargaExercicio);
        TextView observacoes = itemLista.findViewById(R.id.observacoesExercicio);

        exercicio.setText(this.exercicioTreino.getNomeExercicio());
        ordem.setText(this.exercicioTreino.getOrdem());
        series.setText(this.exercicioTreino.getSeries());
        qtdRepeticoes.setText(this.exercicioTreino.getQtdRepeticoes());
        carga.setText(String.valueOf(this.exercicioTreino.getCarga()));
        observacoes.setText(this.exercicioTreino.getObservacoes());

        return itemLista;
    }
}
