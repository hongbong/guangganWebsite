package com.guanggan.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guanggan.website.entity.User;
import com.guanggan.website.mapper.UserMapper;
import com.guanggan.website.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @NAME: UserServiceImpl
 * @USER: hongbong
 * @DATE: 2023/4/6
 * @TIME: 13:48
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
