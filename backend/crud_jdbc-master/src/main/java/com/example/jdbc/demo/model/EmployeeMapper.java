package com.example.jdbc.demo.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<EmployeeResult> {
    @Override
    public EmployeeResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setAge(rs.getInt("age"));
        employee.setName(rs.getString("name"));
        employee.setActive(rs.getString("active"));
        employee.setJabatan(rs.getInt("jabatan"));
        employee.setDivisi(rs.getInt("divisi"));

        EmployeeResult employeeResult = new EmployeeResult();
        employeeResult.setId(rs.getInt("id"));
        employeeResult.setAge(rs.getInt("age"));
        employeeResult.setName(rs.getString("name"));
        employeeResult.setActive(rs.getString("active"));
        employeeResult.setJabatan(rs.getInt("jabatan"));
        employeeResult.setDivisi(rs.getInt("divisi"));
        employeeResult.setNamaJabatan(rs.getString("nm_jabatan"));
        employeeResult.setNamaDivisi(rs.getString("nm_divisi"));
        return employeeResult;
    }
}