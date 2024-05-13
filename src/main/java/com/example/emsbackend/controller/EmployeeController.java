package com.example.emsbackend.controller;

import com.example.emsbackend.entity.Employee;
import com.example.emsbackend.pojo.EmployeePojo;
import com.example.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Build add EMPLOYEE REST API
    @PostMapping
    public ResponseEntity<EmployeePojo> createEmployee(@RequestBody EmployeePojo employeePojo) {
        EmployeePojo savedEmployee = employeeService.createEmployee(employeePojo);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build get EMPLOYEE ReST API
    @GetMapping("/{employeeId}") // Change the path variable name to employeeId
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer employeeId) {
        try {
            EmployeePojo employeePojo = employeeService.getEmployeeById(employeeId);
            return ResponseEntity.ok(employeePojo);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with ID " + employeeId + " not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    // Build get All Employees Rest Api
    @GetMapping
    public ResponseEntity<List<EmployeePojo>> getAllEmployees() {
        List<EmployeePojo> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Build update Employee Rest Api
    @PutMapping("/{employeeId}") // Specify the employeeId in the path
    public ResponseEntity<EmployeePojo> updateEmployee(@PathVariable("employeeId") Integer employeeId, @RequestBody EmployeePojo updatedEmployee) {
        EmployeePojo employeePojo = employeeService.updateEmployee(updatedEmployee, employeeId);
        return ResponseEntity.ok(employeePojo);
    }

    // Build delete employee Rest Api
    @DeleteMapping("{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee with ID " + employeeId + " deleted successfully");
    }
}

