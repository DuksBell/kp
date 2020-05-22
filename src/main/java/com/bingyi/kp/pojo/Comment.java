package com.bingyi.kp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author: dusk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private String aid;
    private String content;
    private String username;
    private Date ctime;
    private Integer articleid;
}
