package com.bingyi.kp.service.impl;

import com.bingyi.kp.mapper.FileMapper;
import com.bingyi.kp.pojo.Fileup;
import com.bingyi.kp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: dusk
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMapper fileMapper;
    @Override
    public int insert(Fileup file) {
        return fileMapper.insert(file);
    }

    @Override
    public int deleteById(Long id) {
        return fileMapper.deleteById(id);
    }

    @Override
    public int update(Fileup file) {
        return fileMapper.update(file);
    }

    @Override
    public List<Fileup> selectByAll() {
        return fileMapper.selectByAll();
    }

    @Override
    public List<Fileup> selectByFile(Fileup fileup) {
        return fileMapper.selectByFile(fileup);
    }
}
