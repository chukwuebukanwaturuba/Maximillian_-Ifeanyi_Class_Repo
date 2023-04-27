package com.maximillian.classassignment.Service;

import com.maximillian.classassignment.Dto.UserDto;

public interface UserService {
    String create(UserDto userDto) throws Throwable;

    UserDto loginUser(UserDto userDto);

    UserDto editUserDetails(UserDto userDto);

    String deleteUser(UserDto userDto);
}
