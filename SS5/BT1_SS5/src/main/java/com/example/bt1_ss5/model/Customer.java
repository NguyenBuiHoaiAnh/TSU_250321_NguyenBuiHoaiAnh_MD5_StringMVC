package com.example.bt1_ss5.model;

import javax.management.relation.Role;

public class Customer {
    private int id;
    private String username;
    private String password;
    private String phone;
    private String address;
    private String gender;
    private String email;
    private Role role;

    public enum Role {
        ADMIN,USER
    }

    public Customer() {
    }

    public Customer(int id, String username, String password, String phone, String address, String gender, String email, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Customer{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", phone='" + phone + '\'' +
               ", address='" + address + '\'' +
               ", gender='" + gender + '\'' +
               ", email='" + email + '\'' +
               ", role=" + role +
               '}';
    }
}
