package com.staxrt.tutorial.services;

import com.staxrt.tutorial.model.SecureUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by ubuntu on 15/05/20.
 */

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {
    private EncryptUserService userService;
    private Converter<SecureUser, UserDetails> userUserDetailsConverter;

    @Autowired
    public void setUserService(EncryptUserService userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier(value = "userToUserDetails")
    public void setUserUserDetailsConverter(Converter<SecureUser, UserDetails> userUserDetailsConverter) {
        this.userUserDetailsConverter = userUserDetailsConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userUserDetailsConverter.convert(userService.findByUserName(username));
    }
}
