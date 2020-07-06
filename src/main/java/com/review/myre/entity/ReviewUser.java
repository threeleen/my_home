package com.review.myre.entity;

public class ReviewUser {
    private Integer id;

    private String userId;

    private String username;

    private String password;

    public ReviewUser() {
    }

    public ReviewUser(Integer id, String userId, String username, String password, String role) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    private String role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}