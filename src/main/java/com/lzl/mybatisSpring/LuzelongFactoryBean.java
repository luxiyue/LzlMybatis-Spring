package com.lzl.mybatisSpring;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;


public class LuzelongFactoryBean implements FactoryBean {
    private SqlSession session;

    private Class mapperClass;

    public LuzelongFactoryBean(Class mapperClass){
        this.mapperClass = mapperClass;
    }

    @Autowired
    public void setSession(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(mapperClass);
        this.session = sqlSessionFactory.openSession();
    }

    @Override
    public Object getObject() throws Exception {
        return session.getMapper(mapperClass);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperClass;
    }
}
