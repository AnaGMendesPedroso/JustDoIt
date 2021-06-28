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
    private ArrayList<ExercicioModel> exerciciosTreino;
    private Context contexto;

    public AdaptadorExercicio(Context contexto, ArrayList<ExercicioModel> exerciciosTreino) {
    this.contexto = contexto;
    this.exerciciosTreino = exerciciosTreino;
    }

    @Override
    public int getCount() {
        return this.exerciciosTreino.size();
    }

    @Override
    public Object getItem(int position) {
        return exerciciosTreino.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
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

        exercicio.setText(this.exerciciosTreino.get(position).getNomeExercicio());
        ordem.setText(this.exerciciosTreino.get(position).getOrdem());
        series.setText(this.exerciciosTreino.get(position).getSeries());
        qtdRepeticoes.setText(this.exerciciosTreino.get(position).getQtdRepeticoes());
        carga.setText(String.valueOf(this.exerciciosTreino.get(position).getCarga()));
        observacoes.setText(this.exerciciosTreino.get(position).getObservacoes());

        return itemLista;
    }
}
