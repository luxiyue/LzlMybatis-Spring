package com.lzl.mapper;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select 'user'; ")
    String getUser();
}
