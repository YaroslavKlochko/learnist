package com.learnist.domain;

public class UserAuth extends User {
    private final String username;
    private final String password;

    public UserAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
