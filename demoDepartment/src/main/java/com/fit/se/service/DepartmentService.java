package com.fit.se.service;

import com.fit.se.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    Department getDepartmentById(int departmentId);

    List<Department> getAllDepartments();

    Department updateDepartmentById(int departmentId, Department newDepartment);

    void deleteDepartmentById(int departmentId);

}
