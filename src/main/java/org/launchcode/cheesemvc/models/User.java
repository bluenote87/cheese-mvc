package org.launchcode.cheesemvc.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull
    @Size(min=5, max=15, message = "Username needs to be between 5 and 15 characters")
    private String username;

    @NotNull
    @Email(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    private String email;

    @NotNull
    @Size(min=6, message = "Password needs at least 6 characters")
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
