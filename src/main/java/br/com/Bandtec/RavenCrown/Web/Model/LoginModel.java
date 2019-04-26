package br.com.Bandtec.RavenCrown.Web.Model;

import org.springframework.stereotype.Component;

@Component
public class LoginModel {

    public String senha;

    public String email;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
