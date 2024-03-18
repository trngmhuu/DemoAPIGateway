package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    public void saveEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int employeeId);

    public void deleteById(int employeeId);

    public Employee updateEmployeeById(int employeeId, Employee employee);

    public void saveListEmployees(List<Employee> employeeList);
}
