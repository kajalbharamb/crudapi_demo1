package com.example.cruddemo.controller;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
// this will talk to this class
public class employeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@Valid @RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/addEmployees")
    public List<Employee> addEmployee(@Valid @RequestBody List<Employee> employees){
        return employeeService.saveEmployees(employees);
    }

    @GetMapping("/employees")
    public List<Employee> findAllProducts(){
        return employeeService.getEmployee();
    }

    @GetMapping("/EmployeeById/{id}")
    public Employee findEmployeeById(@PathVariable int id){
        return  employeeService.getEmployeeById(id);
    }

    @GetMapping("/employee/{name}")
    public Employee FindEmployeeByName(@PathVariable String name){
        return employeeService.getProductByName(name);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@Valid @RequestBody Employee employee){
        return employeeService.updateproduct(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){ return employeeService.deleteProduct(id);
    }
}