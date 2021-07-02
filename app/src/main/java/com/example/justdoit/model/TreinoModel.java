package com.example.justdoit.model;

import java.util.ArrayList;
import java.util.Date;

public class TreinoModel {

    private String nomeTreino;
    private String dataInicio;
    private int freqSemanal;
    private String educadorFisicoResponsavel;
    private String aquecimento;
    private int imagemTreino;
    private int idTreino;
    private ArrayList<ExercicioModel> exerciciosTreino;

    public TreinoModel(String nomeTreino, String dataInicio, int freqSemanal, String educadorFisicoResponsavel, String aquecimento, int imagemTreino, int idTreino, ArrayList<ExercicioModel> exerciciosTreino) {
        this.nomeTreino = nomeTreino;
        this.dataInicio = dataInicio;
        this.freqSemanal = freqSemanal;
        this.educadorFisicoResponsavel = educadorFisicoResponsavel;
        this.aquecimento = aquecimento;
        this.imagemTreino = imagemTreino;
        this.idTreino = idTreino;
        this.exerciciosTreino = exerciciosTreino;
    }

    public TreinoModel(String nomeTreino, String dataInicio, int freqSemanal, String educadorFisicoResponsavel, String aquecimento, int imagemTreino) {
        this.nomeTreino = nomeTreino;
        this.dataInicio = dataInicio;
        this.freqSemanal = freqSemanal;
        this.educadorFisicoResponsavel = educadorFisicoResponsavel;
        this.aquecimento = aquecimento;
        this.imagemTreino = imagemTreino;
    }

    public TreinoModel() {
    }

    public TreinoModel(int treinoId, String nomeTreino, String dataInicio, int freqSemanal, String educador, String aquecimento) {
        this.idTreino=treinoId;
        this.nomeTreino = nomeTreino;
        this.dataInicio = dataInicio;
        this.freqSemanal = freqSemanal;
        this.educadorFisicoResponsavel = educador;
        this.aquecimento = aquecimento;
    }

    public String getNomeTreino() {
        return nomeTreino;
    }

    public void setNomeTreino(String nomeTreino) {
        this.nomeTreino = nomeTreino;
    }

    public int getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(int idTreino) {
        this.idTreino = idTreino;
    }

    public void setImagemTreino(int imagemTreino) {
        this.imagemTreino = imagemTreino;
    }

    public int getImagemTreino() {
        return imagemTreino;
    }

    public ArrayList<ExercicioModel> getExerciciosTreino() {
        return exerciciosTreino;
    }

    public void setExerciciosTreino(ArrayList<ExercicioModel> exerciciosTreino) {
        this.exerciciosTreino = exerciciosTreino;
    }

    public void addExercicioTreino(ExercicioModel exercicio){
        this.exerciciosTreino.add(exercicio);
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getFreqSemanal() {
        return freqSemanal;
    }

    public void setFreqSemanal(int freqSemanal) {
        this.freqSemanal = freqSemanal;
    }

    public String getEducadorFisicoResponsavel() {
        return educadorFisicoResponsavel;
    }

    public void setEducadorFisicoResponsavel(String educadorFisicoResponsavel) {
        this.educadorFisicoResponsavel = educadorFisicoResponsavel;
    }

    public String getAquecimento() {
        return aquecimento;
    }

    public void setAquecimento(String aquecimento) {
        this.aquecimento = aquecimento;
    }
}
