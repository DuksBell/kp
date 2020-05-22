package com.bingyi.kp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: dusk
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {
    private Integer code;
    private String msg;
    private Object data;
}
