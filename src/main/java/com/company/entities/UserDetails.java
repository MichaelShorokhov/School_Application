package com.company.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class UserDetails {
    @Id
    String login;
    @NotEmpty
    String password;
    @NotEmpty
    String auth;

    public UserDetails(String login, @NotEmpty String password) {
        this.login = login;
        this.password = password;
    }

    public UserDetails(String login, String password, String auth) {
        this.login = login;
        this.password = password;
        this.auth = auth;
    }

    public UserDetails() {

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

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
