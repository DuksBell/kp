package com.bingyi.kp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: dusk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Help {
    private Long id;
    private String title;
    private String content;
    private String username;
    private Date helpdate;
}
