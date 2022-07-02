package com.example.multipleDbConnection.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    // 여러 데이터 베이스를 사용하기 위해서는 꼭 주 데이터베이스를 설정 필요
    @Primary
    @Bean(name = "mssql")
    @ConfigurationProperties(prefix = "spring.hikari.mssql.datasource")
    public DataSource getMssqlDataSource() {return DataSourceBuilder.create().type(HikariDataSource.class).build();}


    @Bean(name = "mysql")
    @ConfigurationProperties(prefix = "spring.hikari.mysql.datasource")
    public DataSource getMysqlDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
