package com.gerenciamento.Gerenciamento.Outputs;

import com.gerenciamento.Gerenciamento.Enum.Tipo;
import com.gerenciamento.Gerenciamento.Models.Categoria;

import java.util.Optional;

public class CategoriaOutput {
    private Long id;
    private String nome;
    private Tipo tipo;

    public CategoriaOutput(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.tipo = categoria.getTipo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
