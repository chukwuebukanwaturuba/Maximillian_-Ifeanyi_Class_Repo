package com.maximillian.classassignment.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String Username;
    private String email;
    private String password;
    private String gender;
    private String phoneNumber;
}
