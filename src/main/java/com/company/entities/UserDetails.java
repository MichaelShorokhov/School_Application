package com.company.entities;

import javax.persistence.*;

@Entity
public class UserDetails {
    @Id
    String login;

    String password;

    String auth;

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
