package com.gerenciamento.Gerenciamento.Models;

import com.gerenciamento.Gerenciamento.Dto.UsuarioDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
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

    public Usuario() {
    }

    public Usuario(UsuarioDTO dto) {
        this.nome = dto.getNome();
        this.userName = dto.getUserName();
        this.email = dto.getEmail();
        this.senha = dto.getSenha();
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
