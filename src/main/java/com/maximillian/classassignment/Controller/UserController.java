package com.maximillian.classassignment.Controller;

import com.maximillian.classassignment.Dto.LoginResponse;
import com.maximillian.classassignment.Dto.UserDto;
import com.maximillian.classassignment.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(
            @RequestBody UserDto userDto
    ) throws Throwable {
        return ResponseEntity.ok(userService.create(userDto));
    }

    @PostMapping("/Login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody UserDto userDto, HttpServletRequest httpServletRequest
    ){
        UserDto userDto1 = userService.loginUser(userDto);
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("user_id", userDto1.getId());
        LoginResponse loginResponse = LoginResponse.builder()
                .email(userDto.getEmail())
                .password(userDto1.getPassword())
                .build();
        return ResponseEntity.ok(loginResponse);
    }

    @PutMapping("/editUser")
    public ResponseEntity<String> editUser(
            @RequestBody UserDto userDto, HttpSession session
    ){
        Long id = (Long)session.getAttribute("user_id");
        userDto.setId(id);
        UserDto user = userService.editUserDetails(userDto);
        return ResponseEntity.ok("Edit was successful");
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable Long id, UserDto userDto){
        userDto.setId(id);
       String response = userService.deleteUser(userDto);
       return ResponseEntity.ok(response);
    }
}
