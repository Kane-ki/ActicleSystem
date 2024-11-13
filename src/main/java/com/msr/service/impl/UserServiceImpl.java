package com.msr.service.impl;

import com.msr.mapper.UserMapper;
import com.msr.pojo.User;
import com.msr.service.UserService;
import com.msr.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author wjing
 * @create 2024-11-11 上午11:32
 * @desc
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public void register(String username, String password) {
        //使用MD5方式进行密码加密
        String md5Password = Md5Util.getMD5String(password);
        userMapper.register(username,md5Password);
    }

    @Override
    public void update(User user) {
        //设定修改时间
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }
}
