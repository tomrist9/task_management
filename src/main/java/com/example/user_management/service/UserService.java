package com.example.user_management.service;

import com.example.user_management.model.JWTToken;
import com.example.user_management.model.request.UserAccountRecoveryRequest;
import com.example.user_management.model.request.UserCreateRequest;
import com.example.user_management.model.request.UserRecoverAccountOTPRequest;
import com.example.user_management.model.request.UserSigningRequest;

public interface UserService {
    JWTToken signUp(UserCreateRequest userCreateRequest);
    JWTToken signIn(UserSigningRequest userSigningRequest);
    void sendOTP(UserAccountRecoveryRequest userAccountRecoveryRequest);
    void sendOTPrecover(UserRecoverAccountOTPRequest userRecoverAccountOTPRequest);

}
