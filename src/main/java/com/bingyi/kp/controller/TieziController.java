package com.bingyi.kp.controller;

import com.alibaba.fastjson.JSON;
import com.bingyi.kp.pojo.Review;
import com.bingyi.kp.pojo.Tiezi;
import com.bingyi.kp.service.ReviewService;
import com.bingyi.kp.service.TieziService;
import com.bingyi.kp.utils.JsonUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.ITemplateEngine;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class TieziController extends BaseController{
    @Autowired
    private TieziService tieziService;
    @Autowired
    private ReviewService reviewService;
    @PostMapping("/tiezi")
    @CrossOrigin
    @ResponseBody
    public String insert(Tiezi tiezi, HttpSession session, Model model){
        tiezi.setUsername(session.getAttribute("loginUser").toString());
        tiezi.setTiezidate(new Date());
        System.out.println(tiezi);
        tieziService.insert(tiezi);
        System.out.println(resultOk("保存成功"));
        return resultOk("保存成功");
    }

    @RequestMapping("/tiezi/list")
    public String queryAll(Model model){
        List<Tiezi> tiezis = tieziService.queryAll();
        model.addAttribute("tiezis", tiezis);
        return "new_message";
    }

    @RequestMapping("/deletebyid")
    public String deleteById(@Param("id") String id){
        tieziService.deleteById(Long.valueOf(id));
        reviewService.deleteByTieid(Long.valueOf(id));
        return "forward:/tiezi/list";
    }

    @RequestMapping(value = "/toReviewData/{tieziId}")
    public String query(@PathVariable Long tieziId, Model model){
        Tiezi tiezi = tieziService.selectById(tieziId);
        Review review = new Review();
        review.setTieid(tieziId);
        List<Review> reviews = reviewService.selectByTieid(review);
        model.addAttribute("tiezi",tiezi);
        model.addAttribute("reviews",reviews);
        return "message";
    }
}
