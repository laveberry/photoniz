package com.laveberry.photoniz.user.domain;

import com.laveberry.photoniz.user.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    private String name;

    @Column(name = "nick_name")
    private String nick_name;

    private String email;

    private String password;

    private String salt;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Role user_role;

    @Embedded
    private Address address;

}
