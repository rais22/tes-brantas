package com.example.jdbc.demo.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DivisiMapper implements RowMapper<DivisiResult> {
    @Override
    public DivisiResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        Divisi divisi = new Divisi();
        divisi.setIdDivisi(rs.getInt("id_divisi"));
        divisi.setNamaDivisi(rs.getString("nm_divisi"));
       
        DivisiResult divisiResult = new DivisiResult();
        divisiResult.setIdDivisi(rs.getInt("id_divisi"));
        divisiResult.setNamaDivisi(rs.getString("nm_divisi"));
        return divisiResult;
    }
}