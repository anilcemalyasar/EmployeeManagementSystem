package com.tutorial.employeemanagement.service;

import com.tutorial.employeemanagement.model.dto.CreateEmployeeDTO;
import com.tutorial.employeemanagement.model.dto.GetEmployeeDTO;

public interface EmployeeService {
    GetEmployeeDTO createEmployee(CreateEmployeeDTO createEmployeeDTO);
    GetEmployeeDTO getEmployee(Long id);
}
