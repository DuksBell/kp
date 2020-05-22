package com.bingyi.kp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: dusk
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Fileup {
    private Long fid;
    private String username;
    private String path;
    private Date ctime;
    private String filename;
    private Integer total;
}
