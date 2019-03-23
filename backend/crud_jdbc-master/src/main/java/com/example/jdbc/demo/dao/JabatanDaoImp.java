package com.example.jdbc.demo.dao;


import com.example.jdbc.demo.model.Jabatan;
import com.example.jdbc.demo.model.JabatanMapper;
import com.example.jdbc.demo.model.JabatanResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Transactional
@Repository
public class JabatanDaoImp implements JabatanDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<JabatanResult> getAll() {
        String sql = "select * from jabatan order by id_jabatan asc";
        List<JabatanResult> jabatan = jdbcTemplate.query(sql, new JabatanMapper());
        return jabatan;
    }

    @Override
    public JabatanResult getJabatanByIdJabatan(int id_jabatan) {
        String sql2 = "select * from jabatan where id_jabatan = ?";
        JabatanResult jabatan2 = jdbcTemplate.queryForObject(sql2, new Object[]{id_jabatan}, new JabatanMapper());
        return jabatan2;
    }

    @Override
    public void addJabatan(Jabatan jabatan) {
        String sql = "INSERT INTO jabatan (id_jabatan, nm_jabatan) VALUES (?, ?) ";
        jdbcTemplate.update(sql, getRandomNumber(), jabatan.getNamaJabatan());
    }

    @Override
    public void updateJabatan(Jabatan jabatan, int id_jabatan) {
        String sql = "update jabatan set nm_jabatan=? where id_jabatan=?";
        jdbcTemplate.update(sql, jabatan.getNamaJabatan(), id_jabatan);

    }

    @Override
    public void deleteJabatanByIdJabatan(int id_jabatan) {
        String sql = "delete from jabatan where id_jabatan=?";
        jdbcTemplate.update(sql, id_jabatan);
    }

    private int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(50);
    }

    @Override
    public int latestInput() {
        String sql2 = "SELECT currval(pg_get_serial_sequence('jabatan','id_jabatan'))";
        int id_jabatan = jdbcTemplate.queryForObject(sql2, Integer.class);
        return id_jabatan;
    }
}