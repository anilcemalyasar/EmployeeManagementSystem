package com.tutorial.employeemanagement.controller;

import com.tutorial.employeemanagement.model.dto.CreateEmployeeDTO;
import com.tutorial.employeemanagement.model.dto.GetEmployeeDTO;
import com.tutorial.employeemanagement.model.dto.UpdateEmployeeDTO;
import com.tutorial.employeemanagement.model.entity.Employee;
import com.tutorial.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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

    // Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<GetEmployeeDTO> getEmployee(@PathVariable Long id) {
        GetEmployeeDTO getEmployeeDTO = employeeService.getEmployee(id);
        return new ResponseEntity<>(getEmployeeDTO, HttpStatus.OK);
    }

    // Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<GetEmployeeDTO>> getEmployees() {
        List<GetEmployeeDTO> employeeDTOS = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
    }

    // Build Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<GetEmployeeDTO> updateEmployee(@PathVariable Long id,
                                                         @RequestBody UpdateEmployeeDTO updateEmployeeDTO) {
        GetEmployeeDTO employeeDTO = employeeService.updateEmployee(id, updateEmployeeDTO);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        String message = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(message);
    }

}
