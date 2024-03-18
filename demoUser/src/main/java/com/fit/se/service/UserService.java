package com.fit.se.service;

import com.fit.se.dto.ResponseDto;
import com.fit.se.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User saveUser(User user);

    public ResponseDto getUser(int userId);

    public List<User> getAllUser();

}
