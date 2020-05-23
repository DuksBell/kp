package com.bingyi.kp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private Long id;
    private String userid;
    private String content;
    private Long tieid;
    private Date ctime;
    private Long hid;
    private Long childid;
    private String username;

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", content='" + content + '\'' +
                ", tieid=" + tieid +
                ", ctime=" + ctime +
                ", hid=" + hid +
                '}';
    }
}
