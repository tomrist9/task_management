package com.example.user_management.security;

import com.example.user_management.constant.SecurityConstant;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private SecurityConstant securityConstants;

    @Autowired
    private AuthenticationFilter filter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.antMatchers(securityConstants.getWhiteList()).permitAll();
                    auth.anyRequest().authenticated();
                })
                .exceptionHandling(h -> h.authenticationEntryPoint((request, response, authException) -> {
                    if (response.getStatus() == 200) {
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                    }
                }))
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore((Filter) filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
