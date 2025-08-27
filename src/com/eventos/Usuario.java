package com.eventos;

import java.io.Serializable;

class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {
        return nome + " (" + email + ")";
    }
}