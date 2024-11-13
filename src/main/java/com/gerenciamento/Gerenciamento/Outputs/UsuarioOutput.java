package com.gerenciamento.Gerenciamento.Outputs;

import com.gerenciamento.Gerenciamento.Models.Usuario;

import java.util.Optional;

public class UsuarioOutput {
    private Long id;
    private String nome;
    private String senha;

    public UsuarioOutput(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.senha = usuario.getSenha();
    }

    public UsuarioOutput(Optional<Usuario> usuario) {
        this.id = usuario.get().getId();
        this.nome = usuario.get().getNome();
        this.senha = usuario.get().getSenha();
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
