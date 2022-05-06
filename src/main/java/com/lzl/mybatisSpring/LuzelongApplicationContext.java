package com.lzl.mybatisSpring;

import com.lzl.mapper.OrderMapper;
import com.lzl.mapper.UserMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LuzelongApplicationContext extends AnnotationConfigApplicationContext {

    public LuzelongApplicationContext(Class<?>... componentClasses) {
        super();
        this.register(componentClasses);
        //个性化设置
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(LuzelongFactoryBean.class);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(OrderMapper.class);
        this.registerBeanDefinition("orderMapper",beanDefinition);

        AbstractBeanDefinition beanDefinition1 = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition1.setBeanClass(LuzelongFactoryBean.class);
        beanDefinition1.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
        this.registerBeanDefinition("userMapper",beanDefinition1);

        //结束
        this.refresh();
    }
}
