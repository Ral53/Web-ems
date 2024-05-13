package com.example.emsbackend.mapper;

import com.example.emsbackend.entity.Employee;
import com.example.emsbackend.pojo.EmployeePojo;

public class EmployeeMapper
{
    public static EmployeePojo mapToEmployeePojo(Employee employee) {
        return new EmployeePojo(
                employee.getEmployee_id(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeePojo employeePojo) {
        return new Employee(
                employeePojo.getId(),
                employeePojo.getFirstName(),
                employeePojo.getLastName(),
                employeePojo.getEmail()
        );
    }
}
