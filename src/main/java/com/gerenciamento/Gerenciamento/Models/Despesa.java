package com.gerenciamento.Gerenciamento.Models;

import com.gerenciamento.Gerenciamento.Dto.DespesaDTO;
import com.gerenciamento.Gerenciamento.Dto.ReceitaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "despesa")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idcategoria", nullable = false)
    @NotNull(message = "O campo categoria é obrigatório")
    private Categoria categoria;

    @Column(nullable = false)
    @NotNull(message = "O campo valor é obrigatório")
    private BigDecimal valor;

    @Column
    private String descricao;

    @Column(nullable = false)
    @NotNull(message = "O campo data é obrigatório")
    private LocalDate data;

    public Despesa() {
    }

    public Despesa(DespesaDTO dto, Usuario usuario, Categoria categoria) {
        this.usuario = usuario;
        this.categoria = categoria;
        this.valor = dto.getValor();
        this.descricao = dto.getDescricao();
        this.data = dto.getData();
    }

    public Despesa(DespesaDTO dto, Categoria categoria) {
        this.categoria = categoria;
        this.valor = dto.getValor();
        this.descricao = dto.getDescricao();
        this.data = dto.getData();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuarior() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    // Getters e setters
}
