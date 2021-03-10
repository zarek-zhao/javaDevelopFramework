package com.zarek.utils;

import java.util.UUID;

/**
 * @author zhao
 * @date 2021/2/27 18:36
 */
public class UUIDUtil {

    public static  String getUUID(){

        return UUID.randomUUID().toString().replace("-","");

    }
}
