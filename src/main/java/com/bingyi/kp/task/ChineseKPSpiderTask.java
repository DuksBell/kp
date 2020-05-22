package com.bingyi.kp.task;

import com.bingyi.kp.spider.ChineseKpPageProcessor;
import com.bingyi.kp.spider.ChineseKpPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import us.codecraft.webmagic.Spider;


/**
 * @author bingyi
 */
@Configuration
@EnableScheduling
public class ChineseKPSpiderTask {

    @Autowired
    private ChineseKpPipeline chineseKpPipeline;

    //@Scheduled(cron = "0 1 * * * ? ")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=1000*60*60*1)
    private void configureTasks() {
        Spider.create(new ChineseKpPageProcessor())
                .addUrl("http://www.kepu.gov.cn/www/articlelist/dtxw?page=1&pageSize=12")
                .addPipeline(chineseKpPipeline)
                .thread(10)
                .run();
    }
}
