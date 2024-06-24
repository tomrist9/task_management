package com.example.user_management.service;

public interface CustomMailService {
    void sendRegistrationCompletedNotification(String message, String to);
    void sendOTP(String to, String otp);
}
