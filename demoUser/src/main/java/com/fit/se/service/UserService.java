package com.fit.se.service;

import com.fit.se.dto.ResponseDto;
import com.fit.se.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public ResponseDto getUser(int userId);

    public List<User> getAllUser();

    public void deleteUserById(int userId);

    public User updateUserById(int userId, User newUser);

}
