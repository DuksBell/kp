package com.bingyi.kp.service.impl;

import com.bingyi.kp.mapper.ReviewMapper;
import com.bingyi.kp.pojo.Review;
import com.bingyi.kp.service.ReviewService;
import com.bingyi.kp.service.TieziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;
    @Override
    public void deleteByTieid(Long tieid) {
        reviewMapper.deleteByTieid(tieid);
    }

    @Override
    public List<Review> selectByTieid(Review review) {
        return reviewMapper.selectByTieid(review);
    }

    @Override
    public void insert(Review review) {

    }
}
