package com.bingyi.kp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Springboot 启动类
 * @author bingyi
 */
@SpringBootApplication
public class KpApplication {

    public static void main(String[] args) {
        // 启动项目
        SpringApplication.run(KpApplication.class, args);
    }

}
