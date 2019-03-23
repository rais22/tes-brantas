package com.example.jdbc.demo.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JabatanMapper implements RowMapper<JabatanResult> {
    @Override
    public JabatanResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        Jabatan jabatan = new Jabatan();
        jabatan.setIdJabatan(rs.getInt("id_jabatan"));
        jabatan.setNamaJabatan(rs.getString("nm_jabatan"));
       
        JabatanResult jabatanResult = new JabatanResult();
        jabatanResult.setIdJabatan(rs.getInt("id_jabatan"));
        jabatanResult.setNamaJabatan(rs.getString("nm_jabatan"));
        return jabatanResult;
    }
}