package com.bingyi.kp.service;

import com.bingyi.kp.pojo.Review;

import java.util.List;

public interface ReviewService{
    void deleteByTieid(Long tieid);
    List<Review> selectByTieid(Review review);
    void insert(Review review);
}
