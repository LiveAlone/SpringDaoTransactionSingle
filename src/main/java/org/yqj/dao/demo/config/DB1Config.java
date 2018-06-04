package org.yqj.dao.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author yaoqijun on 2018-03-12.
 */
@Configuration
@Slf4j

public class DB1Config {

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource());
        return txManager;
    }

    @Bean
    public DataSource dataSource(){
        return createHikariDataSource();
    }

    private DataSource createHikariDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/db1?autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("anywhere");
        return dataSource;
    }

//    private DataSource createDruidDataSource(){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/db1?autoReconnect=true&useSSL=false");
//        dataSource.setUsername("root");
//        dataSource.setPassword("anywhere");
//        dataSource.setMinIdle(10);
//        dataSource.setMaxActive(50);
//        dataSource.setMaxWait(30000);
//        dataSource.setInitialSize(10);
//        dataSource.setRemoveAbandoned(true);
//        dataSource.setRemoveAbandonedTimeout(280); // sec
//        dataSource.setTimeBetweenEvictionRunsMillis(60000);
//        dataSource.setMinEvictableIdleTimeMillis(300000); //
//        dataSource.setValidationQuery("SELECT 1 FROM DUAL");
//        dataSource.setTestOnBorrow(true);
//        return dataSource;
//    }

}
