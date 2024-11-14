package com.gerenciamento.Gerenciamento.Outputs;

import com.gerenciamento.Gerenciamento.Models.Usuario;

import java.util.Optional;

public class UsuarioOutput {
    private Long id;
    private String login;
    private String senha;

    public UsuarioOutput(Usuario usuario) {
        this.id = usuario.getId();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
