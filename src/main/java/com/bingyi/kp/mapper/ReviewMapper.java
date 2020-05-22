package com.bingyi.kp.mapper;

import com.bingyi.kp.pojo.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<Review> queryall();
    void deleteByTieid(Long tieid);
    List<Review> selectByTieid(Review review);
    void insert(Review review);
}
