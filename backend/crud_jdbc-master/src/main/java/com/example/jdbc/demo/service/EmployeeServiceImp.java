package com.example.jdbc.demo.service;

import com.example.jdbc.demo.dao.EmployeeDao;
import com.example.jdbc.demo.model.Employee;
import com.example.jdbc.demo.model.EmployeeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<EmployeeResult> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public EmployeeResult getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee, int id) {
        employeeDao.updateEmployee(employee, id);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeDao.deleteEmployeeById(id);
    }

    @Override
    public int latestInput() {
        return employeeDao.latestInput();
    }

}
