package com.bingyi.kp.service;

import com.bingyi.kp.pojo.Fileup;

import java.util.List;

public interface FileService {

    int insert(Fileup file);

    int deleteById(Long id);

    int update(Fileup file);

    List<Fileup> selectByAll();

    List<Fileup> selectByFile(Fileup fileup);
}
