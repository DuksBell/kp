package com.bingyi.kp.mapper;

import com.bingyi.kp.pojo.Fileup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {

    int insert(Fileup file);

    int deleteById(Long id);

    int update(Fileup file);

    List<Fileup> selectByAll();

    List<Fileup> selectByFile(Fileup fileup);

    List<Fileup> selectToTotal();
}
