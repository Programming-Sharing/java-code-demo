package com.ps.routingdatasources.repository;

import com.ps.routingdatasources.entities.Employees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employees, Integer> {
}
