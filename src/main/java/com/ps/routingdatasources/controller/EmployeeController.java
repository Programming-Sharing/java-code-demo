package com.ps.routingdatasources.controller;

import com.ps.routingdatasources.constants.BranchList;
import com.ps.routingdatasources.datasource.BranchContextHolder;
import com.ps.routingdatasources.entities.Employees;
import com.ps.routingdatasources.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<Employees>> getEmployees(@RequestParam(name = "br", required = false, defaultValue = "") String branch){

        // Update BranchContextHolder
        switch (branch){
            case "branch01":
                BranchContextHolder.setBranchContext(BranchList.BRANCH_1);
                break;
            case "branch02":
                BranchContextHolder.setBranchContext(BranchList.BRANCH_2);
                break;
            case "branch03":
                BranchContextHolder.setBranchContext(BranchList.BRANCH_3);
                break;
            default:
                break;

        }

        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

}
