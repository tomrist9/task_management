package com.example.user_management.model.request;

import javax.validation.constraints.Email;

public class UserAccountRecoveryRequest {
    @Email
    private String email;

    private String contactNumber;
}
