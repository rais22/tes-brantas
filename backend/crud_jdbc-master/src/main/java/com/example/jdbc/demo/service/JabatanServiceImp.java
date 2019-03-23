package com.example.jdbc.demo.service;

import com.example.jdbc.demo.dao.JabatanDao;
import com.example.jdbc.demo.model.Jabatan;
import com.example.jdbc.demo.model.JabatanResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JabatanServiceImp implements JabatanService{

    @Autowired
    private JabatanDao jabatanDao;

    @Override
    public List<JabatanResult> getAll() {
        return jabatanDao.getAll();
    }

    @Override
    public JabatanResult getJabatanByIdJabatan(int id_jabatan) {
        return jabatanDao.getJabatanByIdJabatan(id_jabatan);
    }

    @Override
    public void addJabatan(Jabatan jabatan) {
        jabatanDao.addJabatan(jabatan);
    }

    @Override
    public void updateJabatan(Jabatan jabatan, int id_jabatan) {
        jabatanDao.updateJabatan(jabatan, id_jabatan);
    }

    @Override
    public void deleteJabatanByIdJabatan(int id_jabatan) {
        jabatanDao.deleteJabatanByIdJabatan(id_jabatan);
    }

    @Override
    public int latestInput() {
        return jabatanDao.latestInput();
    }

}
