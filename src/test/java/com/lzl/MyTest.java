package com.lzl;

import com.lzl.mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.annotation.Order;

import java.io.IOException;
import java.io.Reader;

public class MyTest {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //可以通过build的第二个参数环境  指定数据库环境
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sessionFactory.getConfiguration().addMapper(OrderMapper.class);
        SqlSession session = sessionFactory.openSession();
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        System.out.println(mapper.getOrder());
        session.close();
    }

}
