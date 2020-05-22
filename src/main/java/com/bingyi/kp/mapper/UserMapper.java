package com.bingyi.kp.mapper;

import com.bingyi.kp.pojo.User;
import org.apache.ibatis.annotations.*;

import java.lang.annotation.Target;
import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAll();

    User selectByName(String name);

    int insert(User user);

    List<User> selectByUser(User user);
}