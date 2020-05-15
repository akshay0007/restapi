package com.staxrt.tutorial.securities;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by ubuntu on 15/05/20.
 */
@Service
public class EncryptionServiceImpl implements EncryptionService {
    StrongPasswordEncryptor strongPasswordEncryptor;

    @Autowired
    public EncryptionServiceImpl(StrongPasswordEncryptor strongPasswordEncryptor) {
        this.strongPasswordEncryptor = strongPasswordEncryptor;
    }

    @Override
    public String encryptPassword(String password) {
       return strongPasswordEncryptor.encryptPassword(password);
    }

    @Override
    public boolean checkEncyptPassword(String plainText, String encryptedText) {
        return strongPasswordEncryptor.checkPassword(plainText, encryptedText);
    }
}
