package com.bingyi.kp.mapper;

import com.bingyi.kp.pojo.Help;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HelpMapper {

    int insert(Help help);

    int delete(Long id);

    int update(Help help);

    List<Help> selectByHelp(Help help);

    List<Help> selectByAll();
}
