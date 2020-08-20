package com.dispolitics.server;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.sql2o.Sql2o;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration implements TransactionManagementConfigurer {

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://91.240.85.7:3306/dispolitics?serverTimezone=UTC");
        dataSource.setUsername("maksim");
        dataSource.setPassword("oregon2");
        return dataSource;
    }

    @Bean
    @Override
    public TransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public Sql2o sql2o() {
        return new Sql2o(dataSource());
    }
}
