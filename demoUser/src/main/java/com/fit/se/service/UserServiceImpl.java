package com.fit.se.service;

import com.fit.se.dto.DepartmentDto;
import com.fit.se.dto.ResponseDto;
import com.fit.se.dto.UserDto;
import com.fit.se.entity.User;
import com.fit.se.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(int userId) {
        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();
        UserDto userDto = mapToUser(user);
        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/departments/" + user.getDepartmentId(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();
        System.out.println(responseEntity.getStatusCode());
        responseDto.setUserDto(userDto);
        responseDto.setDepartmentDto(departmentDto);
        return responseDto;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUserById(int userId, User newUser) {
        User tempUser = userRepository.findById(userId).get();
        // Update firstName
        if (
                Objects.nonNull(newUser.getFirstName()) &&
                        !"".equalsIgnoreCase(newUser.getFirstName())
        )
        {
            tempUser.setFirstName(newUser.getFirstName());
        }

        // Update lastName
        if (
                Objects.nonNull(newUser.getLastName()) &&
                        !"".equalsIgnoreCase(newUser.getLastName())
        )
        {
            tempUser.setLastName(newUser.getLastName());
        }

        // Update email
        if (
                Objects.nonNull(newUser.getEmail()) &&
                        !"".equalsIgnoreCase(newUser.getEmail())
        )
        {
            tempUser.setEmail(newUser.getEmail());
        }

        // Update departmentId
        tempUser.setDepartmentId(newUser.getDepartmentId());
        return userRepository.save(tempUser);
    }

    private UserDto mapToUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }
}
