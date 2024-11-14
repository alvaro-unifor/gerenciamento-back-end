package com.gerenciamento.Gerenciamento.Outputs;

public class LoginOutput {
    private String token;

    public LoginOutput(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
