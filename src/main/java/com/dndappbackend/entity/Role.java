package com.dndappbackend.entity;

import com.dndappbackend.entity.user.Roles;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Roles roles;

    public Role(Roles roles) {
        this.roles = roles;
    }
}