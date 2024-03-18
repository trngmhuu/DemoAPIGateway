package com.fit.se.service;

import com.fit.se.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getListDepartments();

    public Department getDepartmentById(int departmentId);

}
