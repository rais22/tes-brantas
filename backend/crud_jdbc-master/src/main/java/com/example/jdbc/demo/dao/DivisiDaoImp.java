package com.example.jdbc.demo.dao;


import com.example.jdbc.demo.model.Divisi;
import com.example.jdbc.demo.model.DivisiMapper;
import com.example.jdbc.demo.model.DivisiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Transactional
@Repository
public class DivisiDaoImp implements DivisiDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<DivisiResult> getAll() {
        String sql = "select * from divisi order by id_divisi asc";
        List<DivisiResult> divisi = jdbcTemplate.query(sql, new DivisiMapper());
        return divisi;
    }

    @Override
    public DivisiResult getDivisiByIdDivisi(int id_divisi) {
        String sql2 = "select * from divisi where id_divisi = ?";
        DivisiResult divisi2 = jdbcTemplate.queryForObject(sql2, new Object[]{id_divisi}, new DivisiMapper());
        return divisi2;
    }

    @Override
    public void addDivisi(Divisi divisi) {
        String sql = "INSERT INTO divisi (id_divisi, nm_divisi) VALUES (?, ?) ";
        jdbcTemplate.update(sql, getRandomNumber(), divisi.getNamaDivisi());
    }

    @Override
    public void updateDivisi(Divisi divisi, int id_divisi) {
        String sql = "update divisi set nm_divisi=? where id_divisi=?";
        jdbcTemplate.update(sql, divisi.getNamaDivisi(), id_divisi);

    }

    @Override
    public void deleteDivisiByIdDivisi(int id_divisi) {
        String sql = "delete from divisi where id_divisi=?";
        jdbcTemplate.update(sql, id_divisi);
    }

    private int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(50);
    }

    @Override
    public int latestInput() {
        String sql2 = "SELECT currval(pg_get_serial_sequence('divisi','id_divisi'))";
        int id_divisi = jdbcTemplate.queryForObject(sql2, Integer.class);
        return id_divisi;
    }
}