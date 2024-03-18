package com.fit.se.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class GatewayController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/employees")
    public Object getForObjectDepartment() {
        String apiUrl = "http://localhost:8082/employees";
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    @GetMapping("/users")
    public Object getForAllObjectUsers() {
        String apiUrl = "http://localhost:8081/users";
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    @GetMapping("/users/{id}")
    public Object getForObjectUser() {
        String apiUrl = "http://localhost:8081/users/1";
        return restTemplate.getForObject(apiUrl, Object.class);
    }
}
