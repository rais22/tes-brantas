package com.example.jdbc.demo.dao;

import com.example.jdbc.demo.model.Employee;
import com.example.jdbc.demo.model.EmployeeResult;

import java.util.List;

public interface EmployeeDao {
    List<EmployeeResult> getAll();
    EmployeeResult getEmployeeById(int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee, int id);
    void deleteEmployeeById(int id);
    int latestInput();

}