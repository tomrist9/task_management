package com.example.user_management.security;

import com.example.user_management.constant.SecurityConstant;
import com.example.user_management.exceptions.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Component
public class AuthenticationFilter {

    private final SecurityConstant securityConstants;
    private final JWTProvider jwtProvider;
    private final CustomUserDetailsService customUserDetailsService;
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (StringUtils.isNotBlank(authHeader)) {
            if (authHeader.startsWith("Bearer ")) {
                String jwtToken = authHeader.substring(7);
                if (StringUtils.isBlank(jwtToken)) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Bad bearer authentication");
                }
                if (jwtToken.length() > 30) {
                    try {
                        String userId = jwtProvider.extractUserId(jwtToken);
                        UserDetails userDetails = customUserDetailsService.loadUserByUsername(userId);
                        if (SecurityContextHolder.getContext().getAuthentication() == null) {
                            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
                            SecurityContextHolder.getContext().setAuthentication(token);
                        }
                    } catch (JWTVerificationException ex) {
                        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED, "Provide valid Basic authentication header");
                        response.setStatus(401);
                        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
                        return;
                    }
                }
            }
        }


        doFilter(request, response, filterChain);
    }
}