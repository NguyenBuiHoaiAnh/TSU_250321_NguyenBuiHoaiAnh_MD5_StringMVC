package com.example.bt1_ss5.model;

public class UserSession {
    public static Customer customer;

    private int customerId;
    private String username;
    private String role;

    public UserSession() {
    }

    public UserSession(int customerId, String username, String role) {
        this.customerId = customerId;
        this.username = username;
        this.role = role;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
