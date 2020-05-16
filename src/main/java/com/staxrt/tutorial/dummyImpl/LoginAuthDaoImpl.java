package com.staxrt.tutorial.dummyImpl;

import org.springframework.stereotype.Repository;

/**
 * Created by ubuntu on 16/05/20.
 */
@Repository
public class LoginAuthDaoImpl implements LoginAuthDao {
    @Override
    public boolean isAuthenticate(String username, String password) {
        String us = "abc";
        String pass = "abd";
        if (us.equals(username) && pass.equals(password))
            return true;
        return false;
    }
}
