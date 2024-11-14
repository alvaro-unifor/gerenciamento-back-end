package com.gerenciamento.Gerenciamento.Outputs;

import com.gerenciamento.Gerenciamento.Models.Receita;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReceitaOutput {
    private Long id;
    private String descricaoCategoria;
    private BigDecimal valor;
    private String descricao;
    private LocalDate data;

    public ReceitaOutput(Receita receita) {
        this.id = receita.getId();
        this.descricaoCategoria = receita.getCategoria().getNome();
        this.valor = receita.getValor();
        this.descricao = receita.getDescricao();
        this.data = receita.getData();
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
