package com.laveberry.photoniz.user.service;

import com.laveberry.photoniz.config.jwt.JwtTokenProvider;
import com.laveberry.photoniz.exception.CustomException;
import com.laveberry.photoniz.exception.ExceptionType;
import com.laveberry.photoniz.user.domain.User;
import com.laveberry.photoniz.user.enums.Role;
import com.laveberry.photoniz.user.model.*;
import com.laveberry.photoniz.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Override
    public UserDetailModel findUser(String email) {
        User user = userRepository.findUser(email).orElseThrow(() -> new CustomException(ExceptionType.USER_NOT_FOUND));
        return new UserDetailModel(user.getName(), user.getNickName(), user.getEmail(), user.getPhone(), user.getAddress());
    }

    @Override
    public User signUp(SignUpModel signUpModel) {

        if (userRepository.findUser(signUpModel.email()).isPresent()) {
            throw new CustomException(ExceptionType.USER_ALREADY_EXIST);
        }

        CreateUserModel createUserModel = CreateUserModel.builder()
                .email(signUpModel.email())
                .name(signUpModel.name())
                .nickName(signUpModel.nickName())
                .password(signUpModel.password())
                .phone(signUpModel.phone())
                .address(signUpModel.address())
                .build();

        return createUser(createUserModel);
    }

    private User createUser(CreateUserModel createUserModel) {

        User user = User.builder()
                .email(createUserModel.email())
                .name(createUserModel.name())
                .nickName(createUserModel.nickName())
                .password(encoder.encode(createUserModel.password()))
                .phone(createUserModel.phone())
                .address(createUserModel.address())
                .role(Role.USER)
                .build();

        return userRepository.save(user);
    }

    @Override
    public SignInResultModel signIn(SignInModel signInUserModel) {

        User user = userRepository.findUser(signInUserModel.email()).orElseThrow(() -> new CustomException(ExceptionType.USER_NOT_FOUND));

        if (!encoder.matches(signInUserModel.password(), user.getPassword())) {
            throw new CustomException(ExceptionType.SIGN_IN_FAILED);
        }

        String token = jwtTokenProvider.createToken(user.getEmail(), user.getRole().getName());

        return new SignInResultModel(user.getEmail(), true, token);
    }

    @Override
    public UpdateUserResultModel updateUser(UpdateUserModel updateUserModel, String token) {

        String email = jwtTokenProvider.getUserSubject(token);

        User user = userRepository.findUser(email).orElseThrow(() -> new CustomException(ExceptionType.USER_NOT_FOUND));

        user.updateNickName(updateUserModel.nickName());
        user.updatePassword(encoder.encode(updateUserModel.password()));
        user.updatePhone(updateUserModel.phone());
        user.updateAddress(updateUserModel.address());

        return new UpdateUserResultModel(user.getEmail(), true);
    }

}
