package br.com.alura.gerenciador.model;

import java.util.Objects;

public class Usuario {
    private String login;
    private String password;

    public Usuario(){
        super();
    }

    public Usuario(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return login.equals(usuario.login) && password.equals(usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
