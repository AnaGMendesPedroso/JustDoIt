package com.example.justdoit.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.justdoit.ConteudoWebActivity;
import com.example.justdoit.R;
import com.example.justdoit.model.DicaModel;

import java.util.ArrayList;

public class AdaptadorDicas extends BaseAdapter {
    private ArrayList<DicaModel> dicasSaudaveis;
    private Context contexto;

    public AdaptadorDicas(Context contexto, ArrayList<DicaModel> dicaModels) {
    this.contexto = contexto;
    this.dicasSaudaveis = dicaModels;
    }

    @Override
    public int getCount() {
        return this.dicasSaudaveis.size();
    }

    @Override
    public Object getItem(int position) {
        return dicasSaudaveis.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)contexto.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemLista = layoutInflater.inflate(R.layout.item_simples_dica, parent, false);


        ImageView images = itemLista.findViewById(R.id.imagemItem);
        TextView tituloDica = itemLista.findViewById(R.id.tituloDica);
        TextView descricaoDica = itemLista.findViewById(R.id.descricaoDica);
        TextView tituloLink = itemLista.findViewById(R.id.tituloLink);

        images.setImageResource(this.dicasSaudaveis.get(position).getImagem());
        tituloDica.setText(this.dicasSaudaveis.get(position).getTitulo());
        descricaoDica.setText(this.dicasSaudaveis.get(position).getDescricao());
        tituloLink.setText(this.dicasSaudaveis.get(position).getTituloLink());

        tituloLink.setOnClickListener(view -> {
            Intent intent = new Intent(contexto, ConteudoWebActivity.class);
            intent.putExtra("url", dicasSaudaveis.get(position).getLink());
            contexto.startActivity(intent);
        });

        return itemLista;
    }
}
