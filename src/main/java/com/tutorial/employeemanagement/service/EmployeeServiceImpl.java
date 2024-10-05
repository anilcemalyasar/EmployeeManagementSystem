package com.tutorial.employeemanagement.service;

import com.tutorial.employeemanagement.exception.employee.EmployeeDoesNotExistsException;
import com.tutorial.employeemanagement.mapping.EmployeeMapper;
import com.tutorial.employeemanagement.model.dto.CreateEmployeeDTO;
import com.tutorial.employeemanagement.model.dto.GetEmployeeDTO;
import com.tutorial.employeemanagement.model.entity.Employee;
import com.tutorial.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public GetEmployeeDTO createEmployee(CreateEmployeeDTO createEmployeeDTO) {
        Employee employee = employeeMapper.mapCreateEmployeeDTOToEmployee(createEmployeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.employeeToGetEmployeeDTO(savedEmployee);
    }

    @Override
    public GetEmployeeDTO getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                                                .orElseThrow(() -> new EmployeeDoesNotExistsException(id));
        return employeeMapper.employeeToGetEmployeeDTO(employee);
    }
}
