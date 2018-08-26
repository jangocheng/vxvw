package com.snax.vxvw.vxvwcore.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间格式化工具类
 */
public class DateTimeUtils {

    public static String dateTimeFormat(LocalDateTime dateTime){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        return formatter.format(dateTime);
    }
}
