package com.example.user_management.constant;

import lombok.Data;
import lombok.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class SecurityConstant {
    @Value("${security.auth.whitelist}")
    private String[] whiteList;

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${spring.mail.username}")
    private String email;
}
