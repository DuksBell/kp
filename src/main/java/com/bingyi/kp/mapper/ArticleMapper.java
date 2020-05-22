package com.bingyi.kp.mapper;

import com.bingyi.kp.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    int saveArticle(Article Article);

    List<Article> queryArticles();

    List<Article> queryPageArticles(Integer start, Integer size);

    Integer getArticleCount();

    Article selectArticleById(Integer id);
}
