package com.example.emsbackend.service;

import com.example.emsbackend.pojo.EmployeePojo;

import java.util.List;

public interface EmployeeService {
    EmployeePojo createEmployee(EmployeePojo employeePojo);

    EmployeePojo getEmployeeById(Integer id);

    List<EmployeePojo> getAllEmployees();

    EmployeePojo updateEmployee(EmployeePojo updatedEmployee, Integer employeeId);

    void deleteEmployee(Integer employeeId);
}
