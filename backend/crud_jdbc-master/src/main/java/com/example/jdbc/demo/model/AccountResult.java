package com.example.jdbc.demo.model;

public class AccountResult {
    private int username, password, nik;
    // getter dan setter

    public int getNik() {
        return nik;
    }

    public void setNik(int nik) {
        this.nik = nik;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
    
    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

}