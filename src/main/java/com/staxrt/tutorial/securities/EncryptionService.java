package com.staxrt.tutorial.securities;

/**
 * Created by ubuntu on 15/05/20.
 */
public interface EncryptionService {
    String encryptPassword(String password);

    boolean checkEncyptPassword(String plainText, String encryptedText);
}
