package com.example.user_management.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSigningRequest {
    private String email;
    private String password;
    private Boolean isRememberMe;
}
