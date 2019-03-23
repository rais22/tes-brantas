package com.example.jdbc.demo.controller;

import com.example.jdbc.demo.model.Employee;
import com.example.jdbc.demo.model.EmployeeResult;
import com.example.jdbc.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResult> getById(@PathVariable("id") int id) {
       EmployeeResult employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<EmployeeResult>(employee, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeResult>> getAll() {
        List<EmployeeResult> listEmployee = employeeService.getAll();
        return new ResponseEntity<List<EmployeeResult>>(listEmployee, HttpStatus.OK);
    }
    
    @PostMapping("/") 
    public ResponseEntity<List<EmployeeResult>> addEmployee(@RequestBody Employee employee) {
    	employeeService.addEmployee(employee);
    	List<EmployeeResult> listEmployee = employeeService.getAll();
        return new ResponseEntity<List<EmployeeResult>>(listEmployee, HttpStatus.OK);
	}
    /*
    public ResponseEntity<EmployeeResult> addEmployee(@RequestBody Employee employee) {
    	
    	Customer _customer = repository.save(new Customer(customer.getName(), customer.getAge()));
		return _customer;
		/*
        employeeService.addEmployee(employee);
        EmployeeResult employee2 = EmployeeService.getEmployeeById(employeeService.latestInput());
        return new ResponseEntity<EmployeeResult>(employee2, HttpStatus.OK);
        
       
    }
*/
   

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResult> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(employee, id);
        EmployeeResult employee2 = employeeService.getEmployeeById(id);
        return new ResponseEntity<EmployeeResult>(employee2, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeResult> deleteEmployee(@PathVariable("id") int id) {
    	EmployeeResult employee2 = employeeService.getEmployeeById(id);
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<EmployeeResult>(employee2, HttpStatus.OK);
    }
    
}