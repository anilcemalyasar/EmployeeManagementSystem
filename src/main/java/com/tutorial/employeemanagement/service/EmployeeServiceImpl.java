package com.tutorial.employeemanagement.service;

import com.tutorial.employeemanagement.exception.employee.EmployeeDoesNotExistsException;
import com.tutorial.employeemanagement.mapping.EmployeeMapper;
import com.tutorial.employeemanagement.model.dto.CreateEmployeeDTO;
import com.tutorial.employeemanagement.model.dto.GetEmployeeDTO;
import com.tutorial.employeemanagement.model.dto.UpdateEmployeeDTO;
import com.tutorial.employeemanagement.model.entity.Employee;
import com.tutorial.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<GetEmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map((employeeMapper::employeeToGetEmployeeDTO))
                .collect(Collectors.toList());
    }

    @Override
    public GetEmployeeDTO updateEmployee(Long id, UpdateEmployeeDTO updateEmployeeDTO) {
        Employee employee = employeeRepository.findById(id)
                                             .orElseThrow(() -> new EmployeeDoesNotExistsException(id));

        if (updateEmployeeDTO.getFirstName() != null) {
            employee.setFirstName(updateEmployeeDTO.getFirstName());
        }

        if (updateEmployeeDTO.getLastName() != null)  {
            employee.setLastName(updateEmployeeDTO.getLastName());
        }

        if (updateEmployeeDTO.getEmail() != null) {
            employee.setEmail(updateEmployeeDTO.getEmail());
        }

        if (updateEmployeeDTO.getAge() > 0 && updateEmployeeDTO.getAge() < 99) {
            employee.setAge(updateEmployeeDTO.getAge());
        }

        Employee updatedEmployee = employeeRepository.save(employee);

        return employeeMapper.employeeToGetEmployeeDTO(updatedEmployee);
    }

    @Override
    public String deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeDoesNotExistsException(id));

        // Soft Delete ( not removing from database, hold as a deleted entity )
        employee.setDeleted(true);

        // Update deleted-status
        employeeRepository.save(employee);
        return "Employee deleted successfully";
    }
}
