package com.maximillian.classassignment.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_users",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})}
)
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String Username;
    @Column(name = "email",unique = true)
    private String email;
    private String password;
    private String gender;
    private String phoneNumber;
    @CreatedDate
    private LocalDateTime localDateTime;
}
