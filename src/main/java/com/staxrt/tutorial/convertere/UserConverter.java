package com.staxrt.tutorial.convertere;


import com.staxrt.tutorial.model.SecureUser;
import com.staxrt.tutorial.securities.UserDetailImpl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ubuntu on 15/05/20.
 */
@Component
public class UserConverter implements Converter<SecureUser, UserDetails> {


    @Override
    public UserDetails convert(SecureUser secureUser) {
        UserDetailImpl userDetail = new UserDetailImpl();
        userDetail.setUserName(secureUser.getUserName());
        userDetail.setPassword(secureUser.getPassword());
        userDetail.setEnabled(true);
        Collection<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        secureUser.getRoleLists().forEach(r -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(r.getRole()));
        });
        return userDetail;
    }
}
