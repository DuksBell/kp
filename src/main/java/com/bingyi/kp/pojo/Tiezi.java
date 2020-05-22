package com.bingyi.kp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tiezi {
    private Long id;
    private String title;
    private String content;
    private String username;
    private Date tiezidate;
}
