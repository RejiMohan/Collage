package com.collage;

public class User {

    private String name;
    private String username;
    private String password;
    private String email;
    private String designation;
    private String address;
    private Constants.UserType userType;
    private Constants.UserStatus userStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Constants.UserType getUserType() {
        return userType;
    }

    public void setUserType(Constants.UserType userType) {
        this.userType = userType;
    }

    public Constants.UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Constants.UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
