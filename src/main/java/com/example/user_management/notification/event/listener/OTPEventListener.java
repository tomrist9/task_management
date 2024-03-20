package com.example.user_management.notification.event.listener;

import com.example.user_management.notification.OTPNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OTPEventListener {
    private final PersonalizedEmailHandler personalizedEmailHandler;

    @Async
    @EventListener
    public void onEvent(OTPNotification otpNotification){
        personalizedEmailHandler.sendOTP(otpNotification.getEmail(), otpNotification.getOtpCode());
    }
}