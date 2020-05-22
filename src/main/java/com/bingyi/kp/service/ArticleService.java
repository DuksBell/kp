package com.bingyi.kp.service;

import com.bingyi.kp.pojo.Article;

import java.util.List;

/**
 * @author bingyi
 */
public interface ArticleService {
    List<Article> getPageArticles(Integer pageSize, Integer pageNum);

    Integer getArticleCount();

    Article selectArticleById(Integer id);
}
