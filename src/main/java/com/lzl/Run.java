package com.lzl;

import com.lzl.beans.A;
import com.lzl.config.MainConfig;
import com.lzl.mybatisSpring.LuzelongApplicationContext;
import com.lzl.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @Author: luzelong
 * @Date: Created in 2021/11/1
 */
public class Run {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        MyService bean = context.getBean(MyService.class);
        bean.test();
//        AbstractApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//        A bean = context.getBean(A.class);
//        System.out.println(1);
    }
}
