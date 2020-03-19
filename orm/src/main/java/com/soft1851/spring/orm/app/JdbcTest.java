package com.soft1851.spring.orm.app;

import com.soft1851.spring.orm.config.JdbcConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName JdbcTest
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/19
 **/
public class JdbcTest {
    public static void main(String[] args) {
        //生成基于注解配置的应用上下文对象
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcConfig.class);
        //手动开启扫包
        ctx.scan("com.soft1851.spring.ioc.config");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);
    }
}
