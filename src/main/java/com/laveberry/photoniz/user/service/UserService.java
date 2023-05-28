package com.laveberry.photoniz.user.service;


import com.laveberry.photoniz.user.model.SignInModel;
import com.laveberry.photoniz.user.model.SignInResultModel;
import com.laveberry.photoniz.user.model.SignUpUserModel;
import com.laveberry.photoniz.user.domain.User;
import com.laveberry.photoniz.user.model.UserDetailModel;

public interface UserService {


    UserDetailModel findUser(String email);

    User signUp(SignUpUserModel signUpUserModel);

    SignInResultModel signIn(SignInModel signInUserModel);

}
