package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public void deleteById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployeeById(int employeeId, Employee employeeNew) {
        Employee tempEmployee = employeeRepository.findById(employeeId).get();
        if (
                Objects.nonNull(employeeNew.getFirstName()) &&
                !"".equalsIgnoreCase(employeeNew.getFirstName())
        )
        {
            tempEmployee.setFirstName(employeeNew.getFirstName());
        }
        if (
                Objects.nonNull(employeeNew.getLastName()) &&
                        !"".equalsIgnoreCase(employeeNew.getLastName())
        )
        {
            tempEmployee.setLastName(employeeNew.getLastName());
        }
        if (
                Objects.nonNull(employeeNew.getEmail()) &&
                        !"".equalsIgnoreCase(employeeNew.getEmail())
        )
        {
            tempEmployee.setEmail(employeeNew.getEmail());
        }
        return employeeRepository.save(tempEmployee);
    }

    @Override
    public void saveListEmployees(List<Employee> employeeList) {
        employeeRepository.saveAll(employeeList);
    }


}
