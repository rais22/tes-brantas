package com.example.jdbc.demo.dao;

import com.example.jdbc.demo.model.Divisi;
import com.example.jdbc.demo.model.DivisiResult;

import java.util.List;

public interface DivisiDao {
    List<DivisiResult> getAll();
    DivisiResult getDivisiByIdDivisi(int id_divisi);
    void addDivisi(Divisi divisi);
    void updateDivisi(Divisi divisi, int id_divisi);
    void deleteDivisiByIdDivisi(int id_divisi);
    int latestInput();

}