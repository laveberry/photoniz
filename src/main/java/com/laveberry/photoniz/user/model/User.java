package com.laveberry.photoniz.user.model;

import com.laveberry.photoniz.user.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    private String password;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String address;

}
