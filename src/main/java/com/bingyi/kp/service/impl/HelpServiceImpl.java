package com.bingyi.kp.service.impl;

import com.bingyi.kp.mapper.HelpMapper;
import com.bingyi.kp.pojo.Help;
import com.bingyi.kp.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: dusk
 */
@Service
public class HelpServiceImpl implements HelpService {

    @Autowired
    public HelpMapper helpMapper;
    @Override
    public int insert(Help help) {
        return helpMapper.insert(help);
    }

    @Override
    public int delete(Long id) {
        return helpMapper.delete(id);
    }

    @Override
    public int update(Help help) {
        return helpMapper.update(help);
    }

    @Override
    public List<Help> selectByHelp(Help help) {
        return helpMapper.selectByHelp(help);
    }

    @Override
    public List<Help> selectByAll() {
        return selectByAll();
    }
}
