package com.example.user_management.notification.event.listener;

import com.example.user_management.notification.RegistrationCompletedNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class RegistrationCompletedEventListenerNotification {
    private final CustomMailService customMailService;
    @Async
    @EventListener
    public void onEvent(RegistrationCompletedNotification event){
        customMailService.sendRegistrationCompleteNotification(event.getMessage(), event.getTo());
    }
}