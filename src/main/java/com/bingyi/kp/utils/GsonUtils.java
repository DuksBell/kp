package com.bingyi.kp.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 封装 gson 的操作方法
 * @author bingyi
 */
public class GsonUtils {
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
