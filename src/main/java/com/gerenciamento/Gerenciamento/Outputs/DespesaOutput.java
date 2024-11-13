package com.gerenciamento.Gerenciamento.Outputs;

import com.gerenciamento.Gerenciamento.Models.Despesa;
import com.gerenciamento.Gerenciamento.Models.Receita;

import java.math.BigDecimal;

public class DespesaOutput {
    private Long id;
    private String descricaoCategoria;
    private BigDecimal valor;
    private String descricao;

    public DespesaOutput(Despesa despesa) {
        this.id = despesa.getId();
        this.descricaoCategoria = despesa.getCategoria().getNome();
        this.valor = despesa.getValor();
        this.descricao = despesa.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
