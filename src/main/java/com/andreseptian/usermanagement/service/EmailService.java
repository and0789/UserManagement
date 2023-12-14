package com.andreseptian.usermanagement.service;

import com.andreseptian.usermanagement.enumeration.VerificationType;



public interface EmailService {
    void sendVerificationEmail(String firstName,
                               String email,
                               String verificationUrl,
                               VerificationType verificationType);
}
