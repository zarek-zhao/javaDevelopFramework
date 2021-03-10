package com.zarek.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhao
 * @date 2021/2/27 18:27
 */
public class DateTimeUtil {

    public static String currentTime(){

        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);

        return format;
    }


}
