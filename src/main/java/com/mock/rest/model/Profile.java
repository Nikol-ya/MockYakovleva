package com.mock.rest.model;

public class Profile {
    private final int password;
    private final String login;

    public Profile(String login, int password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public int getPassword() {
        return password;
    }
}
