package com.bingyi.kp.service;

import com.bingyi.kp.pojo.User;

import java.util.List;

public interface UserService {
    User SelectByName(String name);

    int insert(User user);

    List<User> selectByUser(User user);

    List<User> getAll();
}
