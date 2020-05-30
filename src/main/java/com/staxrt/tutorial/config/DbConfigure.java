package com.staxrt.tutorial.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by ubuntu on 19/05/20.
 */
@Configuration
@ConfigurationProperties("hikari.datasource")
public class DbConfigure {

    @Bean
    DataSource getDataSource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }


    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(getDataSource());
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setPackagesToScan("com.staxrt.tutorial");
        emf.setPersistenceUnitName("default");
        emf.afterPropertiesSet();
        return emf.getObject();
    }

    //no transaction support due to manual mgt


//    @Bean
//    @Primary
//    @ConfigurationProperties("datasource.oracle")
//    public DataSourceProperties getDatasourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    @ConfigurationProperties("datasource.oracle")
//    public DataSource getDatasource() {
//        return getDatasourceProperties().initializeDataSourceBuilder()
//                .username("username")
//                .password("password")
//                .build();
//    }

//    @Bean
//    public DataSource dataSource() {
//        HikariDataSource ds = new HikariDataSource();
//        ds.setMaximumPoolSize(100);
//        ds.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
//        ds.addDataSourceProperty("url", "jdbc:mysql://localhost:3306/test");
//        ds.addDataSourceProperty("user", "root");
//        ds.addDataSourceProperty("password", "password");
//        ds.addDataSourceProperty("cachePrepStmts", true);
//        ds.addDataSourceProperty("prepStmtCacheSize", 250);
//        ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
//        ds.addDataSourceProperty("useServerPrepStmts", true);
//        return ds;
//    }

}
