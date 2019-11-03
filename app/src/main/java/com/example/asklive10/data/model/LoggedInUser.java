package com.example.asklive10.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String name;
    private String userId;
    private String email;
    private String password;    //TODO: HASH password

    public LoggedInUser(String name, String userId, String email, String password) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public String getDisplayName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() { return password; } //TODO: REMOVE
}
