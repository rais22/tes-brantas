package com.example.jdbc.demo.dao;


import com.example.jdbc.demo.model.Employee;
import com.example.jdbc.demo.model.EmployeeMapper;
import com.example.jdbc.demo.model.EmployeeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;


@Transactional
@Repository
public class EmployeeDaoImp implements EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<EmployeeResult> getAll() {
        String sql = "select * from employee INNER JOIN jabatan ON jabatan.id_jabatan=employee.jabatan INNER JOIN divisi ON employee.divisi=divisi.id_divisi order by id asc";
        List<EmployeeResult> employee = jdbcTemplate.query(sql, new EmployeeMapper());
        return employee;
    }

    @Override
    public EmployeeResult getEmployeeById(int id) {
        String sql2 = "select * from employee INNER JOIN jabatan ON jabatan.id_jabatan=employee.jabatan INNER JOIN divisi ON employee.divisi=divisi.id_divisi where id = ?";
        EmployeeResult employee2 = jdbcTemplate.queryForObject(sql2, new Object[]{id}, new EmployeeMapper());
        return employee2;
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (id, age, name, active, divisi, jabatan) VALUES (?, ?, ?, ?, ?, ?) ";
        jdbcTemplate.update(sql,getRandomNumber(), employee.getAge(), employee.getName(), employee.getActive(), employee.getDivisi(), employee.getJabatan());
    }

    @Override
    public void updateEmployee(Employee employee, int id) {
      
        String sql = "update employee set age=?, name=? ,active=?, jabatan=? ,divisi=? where id=?";
        jdbcTemplate.update(sql, employee.getAge(), employee.getName(), employee.getActive(), employee.getJabatan(), employee.getDivisi(), id);

    }

    @Override
    public void deleteEmployeeById(int id) {
        String sql = "delete from employee where id=?";
        jdbcTemplate.update(sql, id);
    }

    private int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(50);
    }
    
    @Override
    public int latestInput() {
        String sql2 = "SELECT currval(pg_get_serial_sequence('employee','id'))";
        int id = jdbcTemplate.queryForObject(sql2, Integer.class);
        return id;
    }
}