package com.example.user_management.model.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class UserCreateRequest {
    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Surname is required")
    private String surname;

    @Min(message = "Contact number must be longer than 8 digits", value=8)
    @Max(message = "Contact number must be shorter than 18 digits", value=18)
    private String contactNumber;

    @NotEmpty(message = "Username is required")
    private String username;

    @Email(message = "Email is required", nullable=false)
    private String email;

    @Password
    private String password;
    private String address;
    private LocalDateTime birthAt;
    private Boolean isRememberMe;
}
