package com.staxrt.tutorial.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by ubuntu on 19/05/20.
 */
@Configuration
@PropertySource("classpath:datasource_fake.properties")
public class DbConfigFake {

    @Value("${datasource.username}")
    String userName;

    @Value("${datasource.password}")
    String password;

    @Value("${datasource.url}")
    String url;

    @Value("${datasource.env}")
    String env;


    @Bean
    FakeDataSource getFakeDataSource() {
        return new FakeDataSourceBuilder().setUserName(userName)
                .setPassword(password)
                .setEnv(env)
                .setUrl(url)
                .createFakeDataSource();
    }


    @Bean
    public PropertySourcesPlaceholderConfigurer getProps() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public class FakeDataSource {
        String userName;
        String password;
        String url;
        String env;

        public FakeDataSource(String userName, String password, String url, String env) {
            this.userName = userName;
            this.password = password;
            this.url = url;
            this.env = env;
        }
    }


    public class FakeDataSourceBuilder {
        private String userName;
        private String password;
        private String url;
        private String env;

        public FakeDataSourceBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public FakeDataSourceBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public FakeDataSourceBuilder setUrl(String url) {
            this.url = url;
            return this;
        }

        public FakeDataSourceBuilder setEnv(String env) {
            this.env = env;
            return this;
        }

        public FakeDataSource createFakeDataSource() {
            return new FakeDataSource(userName, password, url, env);
        }
    }
}
