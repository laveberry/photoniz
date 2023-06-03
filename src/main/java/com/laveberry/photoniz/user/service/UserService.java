package com.laveberry.photoniz.user.service;


import com.laveberry.photoniz.user.domain.User;
import com.laveberry.photoniz.user.model.*;

public interface UserService {


    UserDetailModel findUser(String email);

    User signUp(SignUpModel signUpModel);

    SignInResultModel signIn(SignInModel signInUserModel);

    UpdateUserResultModel updateUser(UpdateUserModel updateUserModel, String token);
}
