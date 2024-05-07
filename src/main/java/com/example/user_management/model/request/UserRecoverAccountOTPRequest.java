package com.example.user_management.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserRecoverAccountOTPRequest {
    @NotEmpty(message = "OTP code is required")
    private String OTPcode;
    @Email
    private String email;

    @Password
    private String newPassword;
}
