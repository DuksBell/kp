package com.bingyi.kp.controller;

import com.bingyi.kp.pojo.Article;
import com.bingyi.kp.service.ArticleService;
import com.bingyi.kp.utils.GsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author bingyi
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/article/list/{pageSize}/{pageNum}")
    public String articles(@PathVariable Integer pageSize,
                           @PathVariable Integer pageNum,
                           Model model) {

        List<Article> pageArticles = articleService.getPageArticles(pageSize, pageNum);
        Integer articleCount = articleService.getArticleCount();

        Integer pageCount = articleCount / pageSize;
        Integer pageBegin = pageNum - 8 < 1 ? 1 : pageNum - 8;
        Integer pageEnd = pageNum + 8 > pageCount ? pageCount : pageNum + 8;

        model.addAttribute("articles", pageArticles);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("pageBegin", pageBegin);
        model.addAttribute("pageEnd", pageEnd);

        return "index";
    }
}
