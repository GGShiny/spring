package com.thought.it.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author 李亮
 * @date: 2020/7/16
 * @description:
 */
@Configuration
public class JdbcConfiguration {

    @Value("${jdbc.driver}")
    private String jdbcDriver;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    /**
     * 创建QueryRunner对象
     * @param dataSource
     * @return
     */
    @Bean
    public QueryRunner getRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * 获取DataSource对象
     * @return
     */
    @Bean
    public DataSource getDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(jdbcDriver);
            dataSource.setJdbcUrl(jdbcUrl);
            dataSource.setUser(jdbcUsername);
            dataSource.setPassword(jdbcPassword);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return dataSource;
    }
}
