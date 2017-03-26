package com.example.hyunjeong.district132;

/**
 * Created by Hyun Jeong on 2017-03-26.
 */

public class AccountDB {
    private String username;
    private String password;

    public AccountDB() {

    }

    public AccountDB(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
