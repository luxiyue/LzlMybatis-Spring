package com.lzl.config;

import com.lzl.mybatisSpring.LuzelongRegister;
import com.lzl.mybatisSpring.LuzelongScan;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author: luzelong
 * @Date: Created in 2021/11/1
 */
@ComponentScan("com.lzl")
@Configuration
@LuzelongScan("com.lzl.mapper")
//@MapperScan("com.lzl.mapper")
public class MainConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        return sessionFactory;
    }


}
