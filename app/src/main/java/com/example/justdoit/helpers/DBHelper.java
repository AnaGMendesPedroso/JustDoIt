package com.example.justdoit.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import com.example.justdoit.model.ExercicioModel;
import com.example.justdoit.model.TreinoModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "justdoit.db";

    private static final String EXERCICIO_TABLE_NAME = "exercicios";
    private static final String COLUMM_NOME_EXERCICIO = "nomeExercicio";
    private static final String COLUMM_EXERCICIO_ID = "exercicioID";
    private static final String COLUMM_ORDEM = "ordem";
    private static final String COLUMM_SERIES = "series";
    private static final String COLUMM_QTD_REPETICOES = "qtsRepeticoes";
    private static final String COLUMM_CARGA = "carga";
    private static final String COLUMM_OBSERVACOES = "observacoes";

    private static final String TREINO_TABLE_NAME = "treinos";
    private static final String COLUMM_TREINO_ID = "treinoID";
    private static final String COLUMM_NOME_TREINO = "nomeTreino";
    private static final String COLUMM_DATA_INICIO = "dataInicio";
    private static final String COLUMM_FREQUENCIA_SEMANAL = "freqSemanal";
    private static final String COLUMM_EDUCADOR_RESPONSAVEL = "educadorFisicoResponsavel";
    private static final String COLUMM_AQUECIMENTO = "aquecimento";

    private static final String TREINO_EXERCICIO_TABLE_NAME = "treinosExercicios";
    private static final String COLUMM_TREINO_EXERCICIO_ID = "treinoExercicioID";



    private static final String TABLE_CREATE_TREINO =
            "CREATE TABLE " + TREINO_TABLE_NAME + " ("
                    + COLUMM_TREINO_ID + " integer primary key autoincrement,"
                    + COLUMM_NOME_TREINO + " text not null,"
                    + COLUMM_DATA_INICIO + " date not null,"
                    + COLUMM_FREQUENCIA_SEMANAL + " integer not null,"
                    + COLUMM_EDUCADOR_RESPONSAVEL + " text not null,"
                    + COLUMM_AQUECIMENTO + " text not null"
                    + ")";

    private static final String TABLE_CREATE_EXERCICIO =
            "CREATE TABLE " + EXERCICIO_TABLE_NAME + " ("
                    + COLUMM_EXERCICIO_ID + " integer primary key autoincrement,"
                    + COLUMM_NOME_EXERCICIO + " text not null,"
                    + COLUMM_ORDEM + " integer not null,"
                    + COLUMM_SERIES + " integer not null,"
                    + COLUMM_QTD_REPETICOES + " integer not null,"
                    + COLUMM_CARGA + " real not null,"
                    + COLUMM_OBSERVACOES + " text not null"
                    + ")";

    private static final String TABLE_CREATE_TREINO_EXERCICIO =
            "CREATE TABLE " + TREINO_EXERCICIO_TABLE_NAME + " ("
                    + COLUMM_TREINO_EXERCICIO_ID + " integer primary key autoincrement,"
                    + COLUMM_TREINO_ID + " integer not null,"
                    + COLUMM_EXERCICIO_ID + " integer not null,"
                    + "FOREIGN KEY(" + COLUMM_TREINO_ID + ") REFERENCES " + TREINO_TABLE_NAME + " (" + COLUMM_TREINO_ID + "),"
                    + "FOREIGN KEY(" + COLUMM_EXERCICIO_ID + ") REFERENCES " + EXERCICIO_TABLE_NAME + " (" + COLUMM_EXERCICIO_ID + ")"
                    + ")";

    SQLiteDatabase db;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_TREINO);
        db.execSQL(TABLE_CREATE_EXERCICIO);
        db.execSQL(TABLE_CREATE_TREINO_EXERCICIO);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + EXERCICIO_TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void criarExercicio(ExercicioModel exercicio) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMM_NOME_EXERCICIO, exercicio.getNomeExercicio());
        values.put(COLUMM_ORDEM, exercicio.getOrdem());
        values.put(COLUMM_SERIES, exercicio.getSeries());
        values.put(COLUMM_QTD_REPETICOES, exercicio.getQtdRepeticoes());
        values.put(COLUMM_CARGA, exercicio.getCarga());
        values.put(COLUMM_OBSERVACOES, exercicio.getObservacoes());

        db.insert(EXERCICIO_TABLE_NAME, null, values);
        db.close();
    }

    public void criarTreino(TreinoModel treino) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMM_NOME_TREINO, String.valueOf(treino.getNomeTreino()));
        values.put(COLUMM_DATA_INICIO, String.valueOf(treino.getDataInicio()));
        values.put(COLUMM_FREQUENCIA_SEMANAL, treino.getFreqSemanal());
        values.put(COLUMM_EDUCADOR_RESPONSAVEL, treino.getEducadorFisicoResponsavel());
        values.put(COLUMM_AQUECIMENTO, treino.getAquecimento());


        db.insert(TREINO_TABLE_NAME, null, values);
        db.close();
    }

    public void vincularExercicioTreino(TreinoModel treino, ExercicioModel exercicio){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMM_EXERCICIO_ID, String.valueOf(exercicio.getIdExercicio()));
        values.put(COLUMM_TREINO_ID, String.valueOf(treino.getIdTreino()));

        db.insert(TREINO_EXERCICIO_TABLE_NAME, null, values);
        db.close();
    }


    public ArrayList<ExercicioModel> obterExerciciosDeUmTreino(TreinoModel treino){

        String queryExercicioTreino = "SELECT "
                + COLUMM_EXERCICIO_ID
                + " FROM " + TREINO_EXERCICIO_TABLE_NAME
                + " WHERE " + COLUMM_TREINO_ID
                + " = " + treino.getIdTreino();

        Cursor cursorExercicioTreino = db.rawQuery(queryExercicioTreino, null);
        int exercicioId = -1;

        if (cursorExercicioTreino.moveToFirst()) {
            do {
                exercicioId = cursorExercicioTreino.getInt(0);
            } while (cursorExercicioTreino.moveToNext());
        }

        String queryDadosExercicio = "SELECT "
                + COLUMM_NOME_EXERCICIO + ","
                + COLUMM_ORDEM + ","
                + COLUMM_SERIES + ","
                + COLUMM_QTD_REPETICOES + ","
                + COLUMM_CARGA + ","
                + COLUMM_OBSERVACOES
                + " FROM " + TREINO_EXERCICIO_TABLE_NAME
                + " WHERE " + COLUMM_EXERCICIO_ID
                + " = " + exercicioId;

        Cursor cursorDadosExercicio = db.rawQuery(queryDadosExercicio, null);
        ArrayList<ExercicioModel> exercicioTreino = new ArrayList<>();

        if (cursorDadosExercicio.moveToFirst()) {
            do {

                String nome = cursorExercicioTreino.getString(0);
                int ordem = cursorExercicioTreino.getInt(1);
                int series = cursorExercicioTreino.getInt(2);
                int qtdRepeticoes = cursorExercicioTreino.getInt(3);
                float carga = cursorExercicioTreino.getFloat(4);
                String observacoes = cursorExercicioTreino.getString(5);

                ExercicioModel exercicio = new ExercicioModel(nome, ordem, series, qtdRepeticoes, carga, observacoes);
                exercicioTreino.add(exercicio);

            } while (cursorDadosExercicio.moveToNext());
        }
        return exercicioTreino;
    }

    public TreinoModel consultarTreinoHoje(String dataAtual) throws ParseException {

        db = this.getReadableDatabase();

        String queryDadosTreino = "SELECT * FROM " + TREINO_TABLE_NAME + "";

        Cursor cursorQueryDadosTreino = db.rawQuery(queryDadosTreino, null);

        ArrayList<TreinoModel> todosTreinos = new ArrayList<TreinoModel>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        TreinoModel treinoHoje = new TreinoModel();

        if (cursorQueryDadosTreino.moveToFirst()) {
            do {

                int treinoId = cursorQueryDadosTreino.getInt(0);
                String nomeTreino = cursorQueryDadosTreino.getString(1);
                String dataInicio = simpleDateFormat.format(simpleDateFormat.parse(cursorQueryDadosTreino.getString(2)));
                int freqSemanal = cursorQueryDadosTreino.getInt(3);
                String educador = cursorQueryDadosTreino.getString(4);
                String aquecimento = cursorQueryDadosTreino.getString(5);
                TreinoModel treino = new TreinoModel(treinoId,nomeTreino,dataInicio,freqSemanal,educador,aquecimento);
                todosTreinos.add(treino);

            } while (cursorQueryDadosTreino.moveToNext());
        }
        for (TreinoModel t: todosTreinos) {
            if(simpleDateFormat.parse(t.getDataInicio()).after(simpleDateFormat.parse(dataAtual))){
                return t;
            }
        }
        return treinoHoje;
    }

    public int buscarTreinoId(TreinoModel treino){
        db = this.getReadableDatabase();

        String queryIdTreino = "SELECT "
                + COLUMM_TREINO_ID
                + " FROM " + TREINO_TABLE_NAME
                + " WHERE "+ COLUMM_DATA_INICIO + " LIKE '" + treino.getDataInicio() +"'"
                + " AND "+ COLUMM_FREQUENCIA_SEMANAL + " = " + treino.getFreqSemanal() +""
                + " AND "+ COLUMM_EDUCADOR_RESPONSAVEL + " LIKE '" + treino.getEducadorFisicoResponsavel() +"'"
                + " AND "+ COLUMM_AQUECIMENTO + " LIKE '" + treino.getAquecimento() +"'";

        Cursor cursorQueryIdTreino = db.rawQuery(queryIdTreino, null);

        int treinoId = -1;

        if (cursorQueryIdTreino.moveToFirst()) {
            do {
                treinoId = cursorQueryIdTreino.getInt(0);
            } while (cursorQueryIdTreino.moveToNext());
        }
        return treinoId;
    }

    public int buscarExercicioId(ExercicioModel exercicioModel){
        db = this.getReadableDatabase();

        String queryIdExercicio = "SELECT "
                + COLUMM_EXERCICIO_ID
                + " FROM " + EXERCICIO_TABLE_NAME
                + " WHERE "+ COLUMM_NOME_EXERCICIO + " LIKE '" + exercicioModel.getNomeExercicio() +"'"
                + " AND "+ COLUMM_ORDEM + " =" + exercicioModel.getOrdem() +""
                + " AND "+ COLUMM_SERIES + " =" + exercicioModel.getSeries() +""
                + " AND "+ COLUMM_QTD_REPETICOES + " =" + exercicioModel.getQtdRepeticoes() +""
                + " AND "+ COLUMM_CARGA + " =" + exercicioModel.getCarga() +""
                + " AND "+ COLUMM_OBSERVACOES + " LIKE '" + exercicioModel.getObservacoes() +"'";

        Cursor cursorQueryIdTreino = db.rawQuery(queryIdExercicio, null);

        int exercicioId = -1;

        if (cursorQueryIdTreino.moveToFirst()) {
            do {
                exercicioId = cursorQueryIdTreino.getInt(0);
            } while (cursorQueryIdTreino.moveToNext());
        }
        return exercicioId;
    }

    public TreinoModel buscarTreinoPorId(int idTreino) throws ParseException {
        db = this.getReadableDatabase();

        String queryDadosTreino = "SELECT "
                + COLUMM_TREINO_ID + ","
                + COLUMM_DATA_INICIO + ","
                + COLUMM_FREQUENCIA_SEMANAL + ","
                + COLUMM_EDUCADOR_RESPONSAVEL + ","
                + COLUMM_AQUECIMENTO
                + " FROM " + TREINO_TABLE_NAME
                + " WHERE "+ COLUMM_TREINO_ID + " = " + idTreino;

        Cursor cursorQueryDadosTreino = db.rawQuery(queryDadosTreino, null);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        TreinoModel treinoHoje = new TreinoModel();

        if (cursorQueryDadosTreino.moveToFirst()) {
            do {

                int treinoId = cursorQueryDadosTreino.getInt(0);
                String dataInicio = simpleDateFormat.format(simpleDateFormat.parse(cursorQueryDadosTreino.getString(1)));
                int freqSemanal = cursorQueryDadosTreino.getInt(2);
                String educador = cursorQueryDadosTreino.getString(3);
                String aquecimento = cursorQueryDadosTreino.getString(4);
                treinoHoje.setDataInicio(dataInicio);
                treinoHoje.setIdTreino(treinoId);
                treinoHoje.setFreqSemanal(freqSemanal);
                treinoHoje.setEducadorFisicoResponsavel(educador);
                treinoHoje.setAquecimento(aquecimento);

            } while (cursorQueryDadosTreino.moveToNext());
        }
        return treinoHoje;
    }

    public boolean removerTreino(int treinoId){

        db = this.getWritableDatabase();

        String query = "SELECT " + COLUMM_EXERCICIO_ID + " FROM " + TREINO_EXERCICIO_TABLE_NAME + " WHERE " + COLUMM_TREINO_ID + " = " + treinoId;
        Cursor cursor = db.rawQuery(query, null);

        boolean resultado = false;

        if(cursor.moveToFirst()){

            if(cursor.getInt(0) != 0){
                resultado = false;

            } else {
                String deleteTreino = "DELETE FROM " + TREINO_TABLE_NAME + " WHERE " + COLUMM_TREINO_ID + " = " + treinoId;
                db.execSQL(deleteTreino);

                String deleteExercicios = "DELETE FROM " + EXERCICIO_TABLE_NAME + " WHERE " + COLUMM_EXERCICIO_ID + " = "  + cursor.getInt(0);
                db.execSQL(deleteExercicios);
                resultado = true;
            }
        }
        return resultado;
    }
}