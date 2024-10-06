package com.tutorial.employeemanagement.service;

import com.tutorial.employeemanagement.model.dto.CreateEmployeeDTO;
import com.tutorial.employeemanagement.model.dto.GetEmployeeDTO;
import com.tutorial.employeemanagement.model.dto.UpdateEmployeeDTO;

import java.util.List;

public interface EmployeeService {
    GetEmployeeDTO createEmployee(CreateEmployeeDTO createEmployeeDTO);
    GetEmployeeDTO getEmployee(Long id);
    List<GetEmployeeDTO> getAllEmployees();
    GetEmployeeDTO updateEmployee(Long id, UpdateEmployeeDTO updateEmployeeDTO);
    String deleteEmployee(Long id);
}
