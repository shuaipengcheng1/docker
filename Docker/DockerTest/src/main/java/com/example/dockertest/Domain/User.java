package com.example.dockertest.Domain;


import java.io.Serializable;

public class User implements Serializable {
    public String username;
    public String password;
    public String id;

    public User() {
    }

    public User(String username, String password, String id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }
}
