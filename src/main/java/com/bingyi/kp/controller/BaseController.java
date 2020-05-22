package com.bingyi.kp.controller;

import com.alibaba.fastjson.JSON;
import com.bingyi.kp.pojo.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: dusk
 */
public class BaseController {

    public String resultOk(String msg, Object data) {
        Result result =  new Result();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(data);
        String resultStr = JSON.toJSONString(result);
        return resultStr;
    }
    public String resultOk(String msg) {
        return resultOk(msg, null);
    }

    public String resultError(String msg) {
        Result result =  new Result();
        result.setCode(500);
        result.setMsg(msg);
        String resultStr = JSON.toJSONString(result);
        return resultStr;
    }

    public String resultError(Integer code,String msg,String data ){
        Result result =  new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        String resultStr = JSON.toJSONString(result);
        return resultStr;
    }

    public String resultError(Integer code,String msg){
        Result result =  new Result();
        result.setCode(code);
        result.setMsg(msg);
        String resultStr = JSON.toJSONString(result);
        return resultStr;
    }
}

