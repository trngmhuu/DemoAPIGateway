package com.fit.se.service;

import com.fit.se.entity.Department;
import com.fit.se.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartmentById(int departmentId, Department newDepartment) {
        Department tempDepartment = departmentRepository.findById(departmentId).get();
        if (
                Objects.nonNull(newDepartment.getDepartmentName()) &&
                        !"".equalsIgnoreCase(newDepartment.getDepartmentName())
        )
        {
            tempDepartment.setDepartmentName(newDepartment.getDepartmentName());
        }
        if (
                Objects.nonNull(newDepartment.getDepartmentAddress()) &&
                        !"".equalsIgnoreCase(newDepartment.getDepartmentAddress())
        )
        {
            tempDepartment.setDepartmentAddress(newDepartment.getDepartmentAddress());
        }
        if (
                Objects.nonNull(newDepartment.getDepartmentCode()) &&
                        !"".equalsIgnoreCase(newDepartment.getDepartmentCode())
        )
        {
            tempDepartment.setDepartmentCode(newDepartment.getDepartmentCode());
        }
        return departmentRepository.save(tempDepartment);
    }

    @Override
    public void deleteDepartmentById(int departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
