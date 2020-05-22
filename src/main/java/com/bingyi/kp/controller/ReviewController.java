package com.bingyi.kp.controller;

import com.bingyi.kp.pojo.Review;
import com.bingyi.kp.service.ReviewService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping("/review/add")
    public String insert(Review review,Model model){
        System.out.println(review);
        review.setCtime(new Date());
        reviewService.insert(review);
        return "message";
    }
    @RequestMapping("/toReviewData")
    public String getReviewData(@Param("tieziId")String tieziId, Model model){
        Review review = new Review();
        review.setTieid(Long.valueOf(tieziId));
        List<Review> reviews = reviewService.selectByTieid(review);
        model.addAttribute("reviews",reviews);
        return "message";
    }
}
