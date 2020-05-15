package com.staxrt.tutorial.config;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ubuntu on 15/05/20.
 */
@Configuration
public class CommonBeanConfig {

    @Bean
    StrongPasswordEncryptor getEncryptPassword() {
        return new StrongPasswordEncryptor();
    }


}
