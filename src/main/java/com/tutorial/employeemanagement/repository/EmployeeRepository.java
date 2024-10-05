package com.tutorial.employeemanagement.repository;

import com.tutorial.employeemanagement.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
