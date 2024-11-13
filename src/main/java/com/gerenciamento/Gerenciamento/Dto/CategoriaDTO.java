package com.gerenciamento.Gerenciamento.Dto;

import com.gerenciamento.Gerenciamento.Enum.Tipo;

public class CategoriaDTO {
    private String nome;
    private Tipo tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
