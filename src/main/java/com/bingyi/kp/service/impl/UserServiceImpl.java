package com.bingyi.kp.service.impl;

import com.bingyi.kp.mapper.UserMapper;
import com.bingyi.kp.pojo.User;
import com.bingyi.kp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User SelectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> selectByUser(User user) {
        return userMapper.selectByUser(user);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
