package com.bingyi.kp;

import com.bingyi.kp.mapper.ArticleMapper;
import com.bingyi.kp.pojo.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class KpApplicationTests {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void contextLoads() {
        List<Article> articles = articleMapper.queryArticles();
        for (Article a : articles) {
            System.out.println(a);
        }


        Article article = new Article();
        article.setTitle("这是标题");
        article.setContent("这是内容");
        articleMapper.saveArticle(article);
    }

}
