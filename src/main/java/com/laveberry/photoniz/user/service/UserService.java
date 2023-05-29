package com.laveberry.photoniz.user.service;


import com.laveberry.photoniz.user.model.*;
import com.laveberry.photoniz.user.domain.User;

public interface UserService {


    UserDetailModel findUser(String email);

    User signUp(SignUpUserModel signUpUserModel);

    SignInResultModel signIn(SignInModel signInUserModel);

    UpdateUserResultModel updateUser(String email, UpdateUserModel updateUserModel);
}
