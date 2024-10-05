package com.tutorial.employeemanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String age;
}
