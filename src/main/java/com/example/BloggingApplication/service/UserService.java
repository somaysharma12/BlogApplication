package com.example.BloggingApplication.service;

import com.example.BloggingApplication.Model.User;
import com.example.BloggingApplication.Payloads.UserDto;

import java.util.List;


public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
