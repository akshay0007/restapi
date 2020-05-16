package com.staxrt.tutorial.securities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by ubuntu on 15/05/20.
 */
@Service
public class EncryptionServiceImpl implements EncryptionService {
    PasswordEncoder passwordEncoder;

    @Autowired
    public EncryptionServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encryptPassword(String password) {
       return passwordEncoder.encode(password);
    }

    @Override
    public boolean checkEncyptPassword(String plainText, String encryptedText) {
        return passwordEncoder.matches(plainText, encryptedText);
    }
}
