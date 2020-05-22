package com.bingyi.kp.service.impl;

import com.bingyi.kp.mapper.TieziMapper;
import com.bingyi.kp.pojo.Tiezi;
import com.bingyi.kp.service.TieziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TieziServiceImpl implements TieziService {
    @Autowired
    private TieziMapper tieziMapper;
    @Override
    public void insert(Tiezi tiezi) {
        tieziMapper.insert(tiezi);
    }

    @Override
    public List<Tiezi> queryAll() {
        return tieziMapper.queryAll();
    }

    @Override
    public void deleteById(Long id) {
        tieziMapper.deleteById(id);
    }

    @Override
    public Tiezi selectById(Long id) {
        return tieziMapper.selectById(id);
    }
}
