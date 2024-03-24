package com.fit.se.controller;

import com.fit.se.dto.ResponseDto;
import com.fit.se.entity.User;
import com.fit.se.repository.UserRedisRepository;
import com.fit.se.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    @Autowired
    private UserRedisRepository userRedisRepository;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        userRedisRepository.saveUser(user);
        return new ResponseEntity(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable("id") int userId){
        ResponseDto responseDto = userService.getUser(userId);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") int userId) {
        userRedisRepository.deleteById(userId);
        userService.deleteUserById(userId);
    }

    @PutMapping("/{id}")
    public void updateUserById(@PathVariable("id") int userId, @RequestBody User newUser) {
        userRedisRepository.update(newUser);
        userService.updateUserById(userId, newUser);
    }

}
