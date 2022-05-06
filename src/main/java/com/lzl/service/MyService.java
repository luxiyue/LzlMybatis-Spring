package com.lzl.service;

import com.lzl.mapper.OrderMapper;
import com.lzl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;

    public void test(){
        System.out.println(orderMapper.getOrder());
        System.out.println(userMapper.getUser());
    }
}
