package com.example.justdoit.model;

public class ExercicioModel {

    private String nomeExercicio;
    private int idExercicio;
    private int ordem;
    private int series;
    private int qtdRepeticoes;
    private float carga;
    private String observacoes;

    public ExercicioModel(String nomeExercicio, int ordem, int series, int qtdRepeticoes, float carga, String observacoes) {
        this.nomeExercicio = nomeExercicio;
        this.ordem = ordem;
        this.series = series;
        this.qtdRepeticoes = qtdRepeticoes;
        this.carga = carga;
        this.observacoes = observacoes;
    }

    public ExercicioModel() {
    }

    public ExercicioModel(String nomeExercicio, int idExercicio, int ordem, int series, int qtdRepeticoes, float carga, String observacoes) {
        this.nomeExercicio = nomeExercicio;
        this.idExercicio = idExercicio;
        this.ordem = ordem;
        this.series = series;
        this.qtdRepeticoes = qtdRepeticoes;
        this.carga = carga;
        this.observacoes = observacoes;
    }

    public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getQtdRepeticoes() {
        return qtdRepeticoes;
    }

    public void setQtdRepeticoes(int qtdRepeticoes) {
        this.qtdRepeticoes = qtdRepeticoes;
    }

    public float getCarga() {
        return carga;
    }

    public void setCarga(float carga) {
        this.carga = carga;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
