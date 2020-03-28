package com.soft1851.spring.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName JDBCConfig
 * @Description 注解配置版
 * @Author yue_fan
 * @Date 2020/3/19
 **/
@Configuration
@ComponentScan("com.soft1851.spring.web")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class JdbcConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        //配置初始化大小、最小、最大
        druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(20);
        //配置获取链接等待超时的时间
        druidDataSource.setMaxWait(60000);
        //配置间隔多久进行检测
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        //连接池中最小生命时间
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        //禁止自动提交
        druidDataSource.setDefaultAutoCommit(false);
        //预处理事物
        druidDataSource.setDefaultAutoCommit(true);
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
        return new JdbcTemplate(druidDataSource);
    }

    /**
     * 装配事务管理器
     * @param druidDataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource druidDataSource){
        return new DataSourceTransactionManager(druidDataSource);
    }
}
