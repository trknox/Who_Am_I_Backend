package com.revature.whoAmI.auth.dto.requests;

import com.revature.whoAmI.user.User;

import java.util.UUID;

public class NewUserRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public NewUserRequest(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User extractUser(){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setFirstName(getFirstName());
        user.setLastName(getLastName());
        user.setUsername(getUsername());
        user.setPassword(getPassword());
        return user;
    }
}
