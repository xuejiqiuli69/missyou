/**
 * @作者 leokkzhang
 * @创建时间 2020/3/28 23:22
 */
package com.lin.missyou.util;

import com.lin.missyou.bo.PageCounter;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class CommonUtil {
    public static PageCounter convertToPageParameter(Integer start, Integer count) {
        int pageNum = start / count;
        PageCounter pageCounter = PageCounter.builder()
                .page(pageNum)
                .count(count)
                .build();
        return pageCounter;
    }


    public static Boolean isInTimeLine(Date date, Date start, Date end) {
        Long time = date.getTime();
        Long startTime = start.getTime();
        Long endTime = end.getTime();
        return time > startTime && time < endTime;
    }

    public static Calendar addSomeSeconds(Calendar calendar,int seconds){
        calendar.add(Calendar.SECOND,seconds);
        return calendar;
    }

    public static Boolean isOutOfDate(Date expiredTime) {
        Long now = Calendar.getInstance().getTimeInMillis();
        Long expiredTImeStamp = expiredTime.getTime();
        if (now > expiredTImeStamp) {
            return true;
        }
        return false;
    }

    public static String yuanToFenPlainString(BigDecimal p){
        p = p.multiply(new BigDecimal("100"));
        return CommonUtil.toPlain(p);
    }


    public static String timestamp10() {
        Long timestamp13 = Calendar.getInstance().getTimeInMillis();
        String timestamp13str = timestamp13.toString();
        return timestamp13str.substring(0, timestamp13str.length() - 3);
    }

    private static String toPlain(BigDecimal p){
        return p.stripTrailingZeros().toPlainString();
    }
}
