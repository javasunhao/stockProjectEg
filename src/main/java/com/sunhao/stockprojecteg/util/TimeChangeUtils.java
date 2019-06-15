package com.sunhao.stockprojecteg.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeChangeUtils {
    /**
     * 将时间转换为时间戳
     *
     * @param s
     * @return
     * @throws ParseException
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /**
     * 将时间戳转换为时间
     *
     * @param s
     * @return
     */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static String getCurrentDayDate() {
        String s = String.valueOf(System.currentTimeMillis());
        String date = TimeChangeUtils.stampToDate(s);
        return date.split(" ")[0].replace("-", "");
    }

    public static String getCurrentMonthFirstDate() {
        String currentDay = getCurrentDayDate();
        return currentDay.substring(0, currentDay.length() - 2) + "00";
    }
}
