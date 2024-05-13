package com.example.emsbackend.service.impl;

import com.example.emsbackend.entity.Employee;
import com.example.emsbackend.mapper.EmployeeMapper;
import com.example.emsbackend.pojo.EmployeePojo;
import com.example.emsbackend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements com.example.emsbackend.service.EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeePojo createEmployee(EmployeePojo employeePojo) {
        Employee employee = EmployeeMapper.mapToEmployee(employeePojo);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeePojo(savedEmployee);
    }

    @Override
    public EmployeePojo getEmployeeById(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResolutionException("Employee does not exist with given id : " + employeeId));
        return EmployeeMapper.mapToEmployeePojo(employee);
    }

    @Override
    public List<EmployeePojo> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeePojo)
                .toList();
    }

    @Override
    public EmployeePojo updateEmployee(EmployeePojo updatedEmployee, Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResolutionException("Employee does not exist with given id : " + employeeId)
        );
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeePojo(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResolutionException("Employee does not exist with given id : " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
