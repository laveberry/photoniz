package com.laveberry.photoniz.user.domain;

import com.laveberry.photoniz.user.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "user")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    private String name;

    @Column(name = "nick_name")
    private String nickName;

    private String email;

    private String password;

    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Role role;

    @Embedded
    private Address address;

    public void updateNickName(String nickName) {
        if (Objects.nonNull(nickName)) {
            this.nickName = nickName;
        }
    }

    public void updatePhone(String phone) {
        if (Objects.nonNull(phone)) {
            this.phone = phone;
        }
    }

    public void updateAddress(Address address) {
        if (Objects.nonNull(address)) {
            this.address = address;
        }
    }

    public void updatePassword(String password) {
        if (Objects.nonNull(password)) {
            this.password = password;
        }
    }

    public boolean checkRole(Role role) {
        return this.role == role;
    }
}
