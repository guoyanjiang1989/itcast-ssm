package com.itheima.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String DateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = sdf.format(date);
        return s;
    }
}
