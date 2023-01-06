package com.example.demo.testForGetAllUsersMethod.mapper;

import com.example.demo.testForGetAllUsersMethod.dto.UserDto;
import com.example.demo.testForGetAllUsersMethod.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User u){
        UserDto userDto = new UserDto();
        userDto.setFirstName(u.getFirstName());
        userDto.setLastName(u.getLastName());
        userDto.setExpire(u.isExpire());
        return userDto;
    }
}
