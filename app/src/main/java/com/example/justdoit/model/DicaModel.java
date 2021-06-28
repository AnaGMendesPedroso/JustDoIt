package com.example.justdoit.model;

public class DicaModel {
    private String titulo;
    private int imagem;
    private String descricao;
    private String tituloLink;
    private String link;

    public DicaModel(String titulo, int imagem, String descricao, String tituloLink, String link) {
        this.titulo = titulo;
        this.imagem = imagem;
        this.descricao = descricao;
        this.tituloLink = tituloLink;
        this.link = link;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTituloLink() {
        return tituloLink;
    }

    public void setTituloLink(String tituloLink) {
        this.tituloLink = tituloLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
