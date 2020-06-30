package com.ps.routingdatasources.controller;

import com.ps.routingdatasources.entities.Employees;
import com.ps.routingdatasources.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Employees>> getEmployees(){
        ResponseEntity<List<Employees>> response = new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
        return response;
    }

}
