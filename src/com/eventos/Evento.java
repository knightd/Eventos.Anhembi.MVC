package com.eventos;

import java.io.Serializable;

class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String endereco;
    private String categoria;
    private String horario;
    private String descricao;
    private Usuario criador;

    public Evento(String nome, String endereco, String categoria, String horario, String descricao, Usuario criador) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horario = horario;
        this.descricao = descricao;
        this.criador = criador;
    }

    public String getCategoria() { return categoria; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setHorario(String horario) { this.horario = horario; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public String toString() {
        return "\nEvento: " + nome +
                "\nEndereço: " + endereco +
                "\nCategoria: " + categoria +
                "\nHorário: " + horario +
                "\nDescrição: " + descricao +
                "\nCriado por: " + criador + "\n";
    }
}