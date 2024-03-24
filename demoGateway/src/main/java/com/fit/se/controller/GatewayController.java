package com.fit.se.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class GatewayController {

    @Autowired
    private RestTemplate restTemplate;

    //Call Department Project
    @GetMapping("/departments")
    public Object getForObjectDepartments() {
        String apiUrl = "http://localhost:8080/departments";
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    @GetMapping("/departments/{id}")
    public Object getForObjectDepartmentById(@PathVariable("id") int departmentId) {
        String apiUrl = "http://localhost:8080/departments/" + Integer.toString(departmentId);
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    @PostMapping("/departments")
    public Object saveObjectDepartment() {
        String apiUrl = "http://localhost:8080/departments";
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    @DeleteMapping("/departments/{id}")
    public Object deleteObjectDepartmentById(@PathVariable("id") int departmentId) {
        String apiUrl = "http://localhost:8080/departments/" + Integer.toString(departmentId);
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    @PutMapping("/departments/{id}")
    public Object updateObjectDepartmentById(@PathVariable("id") int departmentId) {
        String apiUrl = "http://localhost:8080/departments/" + Integer.toString(departmentId);
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    // Call User Project
    @GetMapping("/users")
    public Object getForAllObjectUsers() {
        String apiUrl = "http://localhost:8081/users";
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    @GetMapping("/users/{id}")
    public Object getForObjectUserById(@PathVariable("id") int userId) {
        String apiUrl = "http://localhost:8081/users/" + Integer.toString(userId);
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    @PostMapping("/users")
    public Object saveObjectUser() {
        String apiUrl = "http://localhost:8080/users";
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    @DeleteMapping("/users/{id}")
    public Object deleteObjectUserById(@PathVariable("id") int userId) {
        String apiUrl = "http://localhost:8080/users/" + Integer.toString(userId);
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    @PutMapping("users/{id}")
    public Object updateObjectUserById(@PathVariable("id") int userId) {
        String apiUrl = "http://localhost:8080/users/" + Integer.toString(userId);
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    // Call Employee Project
    @GetMapping("/employees")
    public Object getForObjectEmployees() {
        String apiUrl = "http://localhost:8082/employees";
        return restTemplate.getForObject(apiUrl, Object.class);
    }


}
