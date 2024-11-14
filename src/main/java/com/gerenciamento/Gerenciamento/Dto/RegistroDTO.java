package com.gerenciamento.Gerenciamento.Dto;

import com.gerenciamento.Gerenciamento.Enum.UserRole;

public class RegistroDTO {
    private String login;
    private String senha;
    private UserRole role;

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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
