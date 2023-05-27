package com.laveberry.photoniz.user.service;


import com.laveberry.photoniz.user.model.SignInModel;
import com.laveberry.photoniz.user.model.SignInResultModel;
import com.laveberry.photoniz.user.model.SignUpUserModel;
import com.laveberry.photoniz.user.domain.User;

public interface UserService {

    String join(String email, String name, String password);

    User findUser(String email);

    User signUp(SignUpUserModel signUpUserModel);

    SignInResultModel signIn(SignInModel signInUserModel);

}
