package com.bingyi.kp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bingyi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private Integer id;
    private String title;
    private String content;

}
