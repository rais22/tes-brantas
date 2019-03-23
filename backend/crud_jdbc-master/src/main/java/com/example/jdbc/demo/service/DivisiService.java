package com.example.jdbc.demo.service;

import com.example.jdbc.demo.model.Divisi;
//import com.example.jdbc.demo.model.Jabatan;
import com.example.jdbc.demo.model.DivisiResult;

import java.util.List;

public interface DivisiService {
    List<DivisiResult> getAll();
    DivisiResult getDivisiByIdDivisi(int id_divisi);
    void addDivisi(Divisi divisi);
    void updateDivisi(Divisi divisi, int id_divisi);
    void deleteDivisiByIdDivisi(int id_divisi);
    int latestInput();
}
