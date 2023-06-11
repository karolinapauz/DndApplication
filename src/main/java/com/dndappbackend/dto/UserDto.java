package com.dndappbackend.dto;

import com.dndappbackend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Boolean enabled;
    private Set<Role> roles;
}
