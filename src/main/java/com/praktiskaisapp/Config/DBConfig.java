package com.praktiskaisapp.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.praktiskaisapp.Rest.Repositories")
public class DBConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("DBdriverClassName", "org.sqlite.JDBC"));
        dataSource.setUrl(env.getProperty("datasourceurl", "jdbc:sqlite:file:myDb.db?cache=shared"));
        dataSource.setUsername(env.getProperty("username", "robo"));
        dataSource.setPassword(env.getProperty("password", "1234"));
        return dataSource;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.praktiskaisapp.Rest.Entity");
        em.setJpaVendorAdapter (new HibernateJpaVendorAdapter());
        em.setJpaProperties(additionalProperties());
        return em;
    }

    final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto", "create"));
        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.SQLiteDialect");
        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql", "true"));
        return hibernateProperties;
    }
}

