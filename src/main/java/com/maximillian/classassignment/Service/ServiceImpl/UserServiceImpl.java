package com.maximillian.classassignment.Service.ServiceImpl;

import com.maximillian.classassignment.Dto.UserDto;
import com.maximillian.classassignment.Entity.Users;
import com.maximillian.classassignment.Repository.UserRepository;
import com.maximillian.classassignment.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public String create(UserDto userDto) throws Throwable {
        Optional<Users> user = userRepository.findByEmail(userDto.getEmail());
        if(!user.isPresent()){
            Users newUser = mapDtoToEntity(userDto);
            userRepository.save(newUser);
            return "User registered successfully";
        }
       throw new RuntimeException("user does not exist");
    }

    @Override
    public UserDto loginUser(UserDto userDto) {
        Users user = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDto(user);
    }

    @Transactional
    @Override
    public UserDto editUserDetails(UserDto userDto) {
        Users user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new RuntimeException("User doesn't exist"));
       return mapToDto(
               userRepository
                       .save(mapDtoToEntity(userDto)));
    }

    @Override
    public String deleteUser(UserDto userDto) {
        Users users = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new RuntimeException("user doesn't exist"));
        userRepository.delete(users);
        return "User successfully removed";
    }


    public static UserDto mapToDto(Users users){
        UserDto userDto = UserDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .gender(users.getGender())
                .password(users.getPassword())
                .phoneNumber(users.getPhoneNumber())
                .Username(users.getUsername())
                .build();
        return userDto;
    }
    public static Users mapDtoToEntity (UserDto user){
        Users users = Users.builder()
                .email(user.getEmail())
                .gender(user.getGender())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .Username(user.getUsername())
                .build();
        return users;
    }
}
