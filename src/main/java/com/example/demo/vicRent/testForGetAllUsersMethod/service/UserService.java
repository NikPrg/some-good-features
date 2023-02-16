package com.example.demo.vicRent.testForGetAllUsersMethod.service;

import com.example.demo.vicRent.testForGetAllUsersMethod.dto.UserDto;
import com.example.demo.vicRent.testForGetAllUsersMethod.mapper.UserMapper;
import com.example.demo.vicRent.testForGetAllUsersMethod.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;


    public List<UserDto> getAllUsers(){
       return userRepo.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }




}


