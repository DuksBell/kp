package com.bingyi.kp.mapper;

import com.bingyi.kp.pojo.Tiezi;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TieziMapper {
    void insert(Tiezi tiezi);
    List<Tiezi> queryAll();
    void deleteById(Long id);
    Tiezi selectById(Long id);
}
