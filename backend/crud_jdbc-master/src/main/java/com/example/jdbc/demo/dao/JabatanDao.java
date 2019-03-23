package com.example.jdbc.demo.dao;

import com.example.jdbc.demo.model.Jabatan;
import com.example.jdbc.demo.model.JabatanResult;

import java.util.List;

public interface JabatanDao {
    List<JabatanResult> getAll();
    JabatanResult getJabatanByIdJabatan(int id_jabatan);
    void addJabatan(Jabatan jabatan);
    void updateJabatan(Jabatan jabatan, int id_jabatan);
    void deleteJabatanByIdJabatan(int id_jabatan);
    int latestInput();

}