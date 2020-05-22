package com.bingyi.kp.spider;

import com.bingyi.kp.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * @author bingyi
 */
@Component
public class ChineseKpPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Autowired
    private static ArticleMapper articleMapper;


    @Override
    public void process(Page page) {

        if(page.getUrl().toString().contains("http://www.kepu.gov.cn/www/article/dtxw/")) {
            page.putField("title", page.getHtml().xpath("//div[@class='detil-new-title]/div/text()").toString());
            page.putField("content", page.getHtml().xpath("//*[@id=\"content\"]").toString());
            page.putField("id", page.getUrl().toString()
                    .substring(page.getUrl().toString().lastIndexOf("/"),page.getUrl().toString().length()));
        } else {
            List<String> urls = page.getHtml().css(".media-heading").links().all();
            if(urls.size()==0) {
                return;
            }
            String pageNum = page.getUrl().toString()
                    .replace("http://www.kepu.gov.cn/www/articlelist/dtxw?page=", "")
                    .replace("&pageSize=12", "");
            pageNum = String.valueOf(Integer.valueOf(pageNum) + 1);
            urls.add("http://www.kepu.gov.cn/www/articlelist/dtxw?page="+ pageNum +"&pageSize=12");
            page.addTargetRequests(urls);
        }

    }

    @Override
    public Site getSite() {
        return site;
    }
}