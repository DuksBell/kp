package com.bingyi.kp.service;

import com.bingyi.kp.pojo.Help;

import java.util.List;

public interface HelpService {
    int insert(Help help);

    int delete(Long id);

    int update(Help help);

    List<Help> selectByHelp(Help help);

    List<Help> selectByAll();
}
