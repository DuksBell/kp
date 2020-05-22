package com.bingyi.kp.service.impl;

import com.bingyi.kp.mapper.ArticleMapper;
import com.bingyi.kp.pojo.Article;
import com.bingyi.kp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bingyi
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getPageArticles(Integer pageSize, Integer pageNum) {
        Integer start = (pageNum-1)*pageSize;
        return articleMapper.queryPageArticles(start, pageSize);
    }

    @Override
    public Integer getArticleCount() {
        return articleMapper.getArticleCount();
    }

    @Override
    public Article selectArticleById(Integer id) {
        return articleMapper.selectArticleById(id);
    }
}
