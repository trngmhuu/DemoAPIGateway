package com.fit.se.controller;

import com.fit.se.entity.Department;
import com.fit.se.repository.DepartmentRedisRepository;
import com.fit.se.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;
    @Autowired
    private DepartmentRedisRepository departmentRedisRepository;

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        departmentRedisRepository.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllDepartments() {
        List<Department> departments = departmentRedisRepository.findAll();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int departmentId) {
        Department department = departmentRedisRepository.findById(departmentId);
        return ResponseEntity.ok(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDeparmentById(@PathVariable("id") int departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        departmentRedisRepository.deleteById(departmentId);
    }

    @PutMapping("/{id}")
    public void updateDepartmentById(@PathVariable("id") int departmentId, @RequestBody Department newDepartment) {
        departmentService.updateDepartmentById(departmentId, newDepartment);
        departmentRedisRepository.update(newDepartment);
    }
}
