package com.tutorial.employeemanagement.controller;

import com.tutorial.employeemanagement.model.dto.CreateEmployeeDTO;
import com.tutorial.employeemanagement.model.dto.GetEmployeeDTO;
import com.tutorial.employeemanagement.model.entity.Employee;
import com.tutorial.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Build Create Employee REST API
    @PostMapping
    public ResponseEntity<GetEmployeeDTO> createEmployee(@RequestBody CreateEmployeeDTO createEmployeeDTO) {
        GetEmployeeDTO getEmployeeDTO = employeeService.createEmployee(createEmployeeDTO);
        return new ResponseEntity<>(getEmployeeDTO, HttpStatus.CREATED);
    }
}
