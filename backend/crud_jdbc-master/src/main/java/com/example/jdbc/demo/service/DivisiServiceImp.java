package com.example.jdbc.demo.service;

import com.example.jdbc.demo.dao.DivisiDao;
import com.example.jdbc.demo.model.Divisi;
import com.example.jdbc.demo.model.DivisiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisiServiceImp implements DivisiService{

    @Autowired
    private DivisiDao divisiDao;

    @Override
    public List<DivisiResult> getAll() {
        return divisiDao.getAll();
    }

    @Override
    public DivisiResult getDivisiByIdDivisi(int id_divisi) {
        return divisiDao.getDivisiByIdDivisi(id_divisi);
    }

    @Override
    public void addDivisi(Divisi divisi) {
        divisiDao.addDivisi(divisi);
    }

    @Override
    public void updateDivisi(Divisi divisi, int id_divisi) {
        divisiDao.updateDivisi(divisi, id_divisi);
    }

    @Override
    public void deleteDivisiByIdDivisi(int id_divisi) {
        divisiDao.deleteDivisiByIdDivisi(id_divisi);
    }

    @Override
    public int latestInput() {
        return divisiDao.latestInput();
    }

}
