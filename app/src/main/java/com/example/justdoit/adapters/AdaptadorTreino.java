package com.example.justdoit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.justdoit.R;
import com.example.justdoit.helpers.DBHelper;
import com.example.justdoit.model.ExercicioModel;
import com.example.justdoit.model.TreinoModel;

import java.text.ParseException;
import java.util.ArrayList;

public class AdaptadorTreino extends BaseAdapter {
    private TreinoModel treino;
    private Context contexto;

    public AdaptadorTreino(Context contexto, TreinoModel treino) {
        this.contexto = contexto;
        this.treino = treino;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)contexto.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemLista = layoutInflater.inflate(R.layout.item_treino, parent, false);

        ImageView images = itemLista.findViewById(R.id.imageViewTreino);
        TextView nomeTreino = itemLista.findViewById(R.id.nomeTreino);

        ListView exercicios = itemLista.findViewById(R.id.listViewExercicios);

        for ( ExercicioModel e: treino.getExerciciosTreino()) {
            exercicios.setAdapter(new AdaptadorExercicio(contexto, e));
        }

        images.setImageResource(this.treino.getImagemTreino());
        nomeTreino.setText(this.treino.getNomeTreino());

        return itemLista;
    }
}
