package com.gerenciamento.Gerenciamento.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    public Usuario() {
    }

    public Usuario(Long id, String nome, String userName, String email, String senha, List<Receita> receitas, List<Despesa> despesas) {
        this.id = id;
        this.nome = nome;
        this.userName = userName;
        this.email = email;
        this.senha = senha;
        this.receitas = receitas;
        this.despesas = despesas;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Receita> receitas;

    @OneToMany(mappedBy = "usuario")
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setIncomes(List<Receita> receitas) {
        this.receitas = receitas;
    }

    public List<Despesa> getExpenses() {
        return despesas;
    }

    public void setExpenses(List<Despesa> despesas) {
        this.despesas = despesas;
    }
}
