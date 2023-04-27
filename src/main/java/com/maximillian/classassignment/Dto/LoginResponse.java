package com.maximillian.classassignment.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LoginResponse {

    private String email;
    private String password;
}
