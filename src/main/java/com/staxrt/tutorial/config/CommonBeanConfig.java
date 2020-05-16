package com.staxrt.tutorial.config;


import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by ubuntu on 15/05/20.
 */
@Configuration
public class CommonBeanConfig {

    @Bean
    StrongPasswordEncryptor getEncryptPasswordData() {
        return new StrongPasswordEncryptor();
    }


}
