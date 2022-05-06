package com.lzl.mybatisSpring;

import com.lzl.mapper.OrderMapper;
import com.lzl.mapper.UserMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Map;

//这个类比较特殊，只能通过@Import进行导入
public class LuzelongRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(LuzelongScan.class.getName());
        //获取@LuzelongScan的扫描路径
        String path = (String)annotationAttributes.get("value");
//        System.out.println(path);

        LuzelongScanner luzelongScanner = new LuzelongScanner(beanDefinitionRegistry);
        luzelongScanner.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return true;
            }
        });
        luzelongScanner.scan(path);
    }
}
