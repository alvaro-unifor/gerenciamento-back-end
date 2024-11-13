package com.gerenciamento.Gerenciamento.Outputs;

import com.gerenciamento.Gerenciamento.Models.Receita;

import java.math.BigDecimal;

public class ReceitaOutput {
    private Long id;
    private String descricao;
    private BigDecimal valor;

    public ReceitaOutput(Receita receita) {
        this.id = receita.getId();
        this.descricao = receita.getCategoria().getNome();
        this.valor = receita.getValor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
