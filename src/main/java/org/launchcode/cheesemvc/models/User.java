package org.launchcode.cheesemvc.models;

public class User {

    private String username;
    private String email;
    private String password;
    private int userId;
    private static int nextId = 1;

    public User(){
        this.userId = nextId;
        nextId++;
    }

    public User (String aName, String aEmail, String aPassword) {
        this();
        this.username = aName;
        this.email = aEmail;
        this.password = aPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }
}