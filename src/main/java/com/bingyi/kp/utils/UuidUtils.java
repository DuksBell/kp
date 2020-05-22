package com.bingyi.kp.utils;

import java.util.UUID;

/**
 * UUID工具类
 * @author bingyi
 */
public class UuidUtils {
    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
