package com.guanggan.website.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guanggan.website.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
