package com.laveberry.photoniz.user.service;

import com.laveberry.photoniz.common.util.Encrypt;
import com.laveberry.photoniz.exception.CustomException;
import com.laveberry.photoniz.exception.ExceptionType;
import com.laveberry.photoniz.user.model.CreateUserModel;
import com.laveberry.photoniz.user.model.SignInModel;
import com.laveberry.photoniz.user.model.SignInResultModel;
import com.laveberry.photoniz.user.model.SignUpUserModel;
import com.laveberry.photoniz.user.enums.Role;
import com.laveberry.photoniz.user.domain.User;
import com.laveberry.photoniz.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String join(String email, String name, String password) {
        return name;
    }

    @Override
    public User findUser(String email) {
        return userRepository.findUser(email).orElseThrow(() -> new CustomException(ExceptionType.USER_NOT_FOUND));
    }

    @Override
    public User signUp(SignUpUserModel signUpUserModel) {

        CreateUserModel createUserModel = CreateUserModel.builder()
                .email(signUpUserModel.email())
                .name(signUpUserModel.name())
                .password(signUpUserModel.password())
                .phone(signUpUserModel.phone())
                .address(signUpUserModel.address())
                .build();

        return createUser(createUserModel);
    }

    private User createUser(CreateUserModel createUserModel) {

        // Salt + SHA65 암호화
        String salt = Encrypt.getSalt();
        String encryptPass = Encrypt.getEncrypt(createUserModel.password(), salt);

        User user = User.builder()
                .email(createUserModel.email())
                .name(createUserModel.name())
                .password(encryptPass)
                .salt(salt)
                .phone(createUserModel.phone())
                .address(createUserModel.address())
                .user_role(Role.USER)
                .build();

        return userRepository.save(user);
    }

    @Override
    public SignInResultModel signIn(SignInModel signInUserModel) {
        User user = findUser(signInUserModel.email());

        if (!user.getPassword().equals(Encrypt.getEncrypt(signInUserModel.password(), user.getSalt()))) {
            throw new CustomException(ExceptionType.USER_NOT_FOUND);
        }
        return new SignInResultModel(user.getEmail(), true);
    }
}
