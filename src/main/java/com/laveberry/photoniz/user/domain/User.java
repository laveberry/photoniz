package com.laveberry.photoniz.user.domain;

import com.laveberry.photoniz.user.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

<<<<<<< HEAD
=======
import java.util.Arrays;
>>>>>>> d90bd479380c659204861e870ca8b943b29ca592
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails {

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

    // 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    // 사용자 id를 반환
    @Override
    public String getUsername() {
        return this.email;
    }

    // 계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 패스워드 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        return true;
    }
}
