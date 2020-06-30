package com.ps.routingdatasources.service;

import com.ps.routingdatasources.entities.Employees;
import com.ps.routingdatasources.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employees> getAllEmployees(){
        List<Employees> results = new ArrayList<>();
        employeeRepository.findAll().forEach(results::add);
        return results;
    }

}
