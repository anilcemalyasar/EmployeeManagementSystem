package com.tutorial.employeemanagement.mapping;

import com.tutorial.employeemanagement.model.dto.CreateEmployeeDTO;
import com.tutorial.employeemanagement.model.dto.GetEmployeeDTO;
import com.tutorial.employeemanagement.model.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    Employee mapCreateEmployeeDTOToEmployee(CreateEmployeeDTO createEmployeeDTO);
    GetEmployeeDTO employeeToGetEmployeeDTO(Employee employee);
}
