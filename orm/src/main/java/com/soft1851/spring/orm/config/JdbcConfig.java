package com.soft1851.spring.orm.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.soft1851.spring.orm.dao.ForumDao;
import com.soft1851.spring.orm.dao.impl.ForumDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName JDBCConfig
 * @Description 注解配置版
 * @Author yue_fan
 * @Date 2020/3/19
 **/
@Configuration
@ComponentScan("com.soft1851.spring.orm")
public class JdbcConfig {
    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/bbs??useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("");
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
}
