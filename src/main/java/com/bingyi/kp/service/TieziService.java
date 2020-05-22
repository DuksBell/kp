package com.bingyi.kp.service;

import com.bingyi.kp.pojo.Tiezi;

import java.util.List;

public interface TieziService {
    void insert(Tiezi tiezi);

    List<Tiezi> queryAll();

    void deleteById(Long id);

    Tiezi selectById(Long id);
}
