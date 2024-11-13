package com.gerenciamento.Gerenciamento.Models;

import com.gerenciamento.Gerenciamento.Enum.Tipo;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categoria {

    public Categoria() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String nome;

    @Enumerated(EnumType.STRING)
    @Column
    Tipo tipo;

    @OneToMany(mappedBy = "categoria")
    private List<Receita> receitas;

    @OneToMany(mappedBy = "categoria")
    private List<Despesa> despesas;

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

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }
}
