package com.example.user_management.service.impl;

import com.example.user_management.constant.SecurityConstant;
import com.example.user_management.service.CustomMailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class CustomMailServiceImpl implements CustomMailService {
    private JavaMailSender javaMailSender;
    private SecurityConstant securityConstant;
    @Override
    public void sendRegistrationCompletedNotification(String message, String to) {
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setSubject("Registration completed successfully");
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom(securityConstant.getEmail());
        simpleMailMessage.setTo(to);

        javaMailSender.send(simpleMailMessage);


    }

    @Override
    public void sendOTP(String to, String otp) {
    SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
    simpleMailMessage.setSubject("Account recover");
    simpleMailMessage.setText("Use this "+otp+"code for recovering account and do not share this code with anyone\n");
    simpleMailMessage.setTo(to);
    simpleMailMessage.setFrom(securityConstant.getEmail());
    javaMailSender.send(simpleMailMessage);
    }
}
