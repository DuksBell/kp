package com.bingyi.kp.spider;

import com.bingyi.kp.mapper.ArticleMapper;
import com.bingyi.kp.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class ChineseKpPipeline implements Pipeline {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {
        String title = resultItems.get("title");
        String content = resultItems.get("content");

        if(title != null && content != null ) {
            Article article = new Article();
            article.setTitle(title);
            article.setContent(content);

            try {
                boolean success = articleMapper.saveArticle(article) > 0;

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }
}