package com.example.user_management.config;

import com.example.user_management.registration.entity.User;
import com.example.user_management.registration.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;

@Configuration
@RequiredArgsConstructor
public class RequestScopeUserManager {
    private final UserRepository userRepository;

    @Bean
    @RequestScope
    public UserInfo requestScopedUser(HttpServletRequest request){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if(authentication==null){
            return null;
        }
        String userId= authentication.getName();
        User user=userRepository.findById(Long.valueOf(userId)).orElse(null);
        return new UserInfo(user);
    }
}
