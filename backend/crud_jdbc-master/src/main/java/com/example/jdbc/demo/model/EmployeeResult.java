package com.example.jdbc.demo.model;

public class EmployeeResult {
    private int id, age, jabatan, divisi;
    private String name, active, nm_jabatan, nm_divisi;
    // getter dan setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
    
    public int getJabatan() {
        return jabatan;
    }

    public void setJabatan(int jabatan) {
        this.jabatan = jabatan;
    }
    
    public int getDivisi() {
        return divisi;
    }

    public void setDivisi(int divisi) {
        this.divisi = divisi;
    }
    
    public String getNamaJabatan() {
        return nm_jabatan;
    }

    public void setNamaJabatan(String nm_jabatan) {
        this.nm_jabatan = nm_jabatan;
    }
    
    public String getNamaDivisi() {
        return nm_divisi;
    }

    public void setNamaDivisi(String nm_divisi) {
        this.nm_divisi = nm_divisi;
    }

}