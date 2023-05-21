package com.laveberry.photoniz.user.model;

import com.laveberry.photoniz.user.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "users")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    private String name;

    private String email;

    private String password;

    private Integer phone;

    @Enumerated(EnumType.STRING)
    private Role user_role;

    private String address;

}
