package com.ucd.micro.monitor.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: NewDateUtil
 * @Description: 基于JAVA8的新时间工具类
 * @Author: liuxin
 * @CreateDate: 2019/11/2 20:55
 * @Version 1.0
 * @Copyright: Copyright2018-2019/11/2 BJCJ Inc. All rights reserved.
 **/
public class NewDateUtil {

    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER_TWO = DateTimeFormatter.ofPattern("yyyy/M/d");

    /**
     * 返回当前时间
     * 例如2019-10-27
     */
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }


    /**
     * 返回当前时间
     * 例如2019-10-27T14:47:04.911
     */
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 返回当前日期字符串 yyyy-MM-dd
     * 例如2019-10-27
     *
     * @return
     */
    public static String getCurrentDateStr() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * 返回当前日期字符串 yyyy-MM-dd
     * 例如2019-10-27 14:49:35
     *
     * @return
     */
    public static String getCurrentDateTimeStr() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    /**
     * 返回前一天日期字符串 yyyy-MM-dd
     * 例如2019-10-26
     *
     * @return
     */
    public static String getYesterdayStr() {
        return LocalDate.now().minusDays(1).format(DATE_FORMATTER);
    }

    /**
     * 返回前一天的七天前日期字符串 yyyy-MM-dd
     * 例如2019-10-19
     *
     * @return
     */
    public static String getYesterday7LaterStr() {
        return LocalDate.now().minusDays(7).format(DATE_FORMATTER);
    }

    /**
     * 返回前一天的十天前日期字符串 yyyy-MM-dd
     * 例如2019-10-19
     *
     * @return
     */
    public static String getYesterday10LaterStr() {
        return LocalDate.now().minusDays(10).format(DATE_FORMATTER);
    }

    /**
     * 返回前一天的三十天前日期字符串 yyyy-MM-dd
     * 例如2019-09-26
     *
     * @return
     */
    public static String getYesterday30LaterStr() {
        return LocalDate.now().minusDays(30).format(DATE_FORMATTER);
    }

    /**
     * 返回上个月月份（自然月）
     * 例如2019-10
     */
    public static String geyLasterMonth() {
        return LocalDate.now().minusMonths(1).format(MONTH_FORMATTER);
    }

    /**
     * 返回一年前月份（自然年）
     * 例如2019-10
     */
    public static String geyLasterYearMonth() {
        return LocalDate.now().minusMonths(12).format(MONTH_FORMATTER);
    }

    /**
     * 获取当前的时区(Asia/Shanghai)
     */
    public static ZoneId currentZone = ZoneId.systemDefault();

    /**
     * 获取当前年
     */
    public static int getYear() {
        return LocalDateTime.now().getYear();
    }

    /**
     * 获取当前月
     */
    public static int getMonth() {
        return LocalDateTime.now().getMonthValue();
    }

    /**
     * 获取当前日(对于当月)
     */
    public static int getDayOfMonth() {
        return LocalDateTime.now().getDayOfMonth();
    }

    /**
     * 获取当前日(对于当年)
     */
    public static int getDayOfYear() {
        return LocalDateTime.now().getDayOfYear();
    }

    /**
     * 获取当前时
     */
    public static int getHour() {
        return LocalDateTime.now().getHour();
    }

    /**
     * 获取当前分
     */
    public static int getMinute() {
        return LocalDateTime.now().getMinute();
    }

    /**
     * 获取当前秒
     */
    public static int getSecond() {
        return LocalDateTime.now().getSecond();
    }

    /**
     * 获取当前纳秒
     */
    public static int getNano() {
        return LocalDateTime.now().getNano();
    }

    /**
     * 获取当前时间 默认获取 UTC 时区
     * 例如2019-10-27T07:18:16.506Z
     */
    public static Instant getInstant() {
        return Instant.now();
    }

    /**
     * 获取中国当前时间
     * 例如2019-10-27T07:18:16.506Z
     */
    public static Instant getCNInstant() {
        return Instant.now().atOffset(ZoneOffset.ofHours(8)).toInstant();
    }

    /**
     * 获取中国当前时间戳
     * 例如1572160834721
     */
    public static String getCNDataLong() {
        long timestamp = Instant.now().atOffset(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
        return String.valueOf(timestamp);
    }

    /**
     * 返回当前时间，格式为yyyyMMdd
     * 例如20191027
     */
    public static String getDate4Query(String data) {
        return data.trim().replace("-", "");
    }

    /**
     * 返回当前时间，格式为yyyy/MM/dd
     * 例如2019/10/27
     */
    public static String getDate4Result(String data) {
        return data.trim().replace("-", "/");
    }

    /**
     * LocalData 转换 Data
     */
    public static Date localDate2Date(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * String 转换 String
     * yyyy-MM-dd
     */
    public static String dealDateFormat(String oldDate) {
        Date date1 = null;
        DateFormat df2 = null;
        Calendar cal = Calendar.getInstance();
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = df.parse(oldDate);
            cal.setTime(date);
            // after 8 hour
            cal.add(Calendar.HOUR_OF_DAY, 8);
            df2 = new SimpleDateFormat("yyyy/M/d");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return df2.format(cal.getTime());
    }

    /**
     * String 转换 String 针对查询日期为0：00时区的数据，手动增加到东八区
     * yyyy-MM-dd
     */
    public static String dealTimeFormat(String oldDate) {
        Date date1 = null;
        DateFormat df2 = null;
        Calendar cal = Calendar.getInstance();
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = df.parse(oldDate);
            // date 换成已经已知的Date对象
            cal.setTime(date);
            // after 8 hour
            cal.add(Calendar.HOUR_OF_DAY, 8);
            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return df2.format(cal.getTime());
    }

    /***
     * @author liuxin
     * @Description 得到当前时间，分钟数统一规整为00，15，30，45
     * @date 2019/11/2 0:02
     * @params []
     * @exception
     * @return java.lang.String
     */
    public static String getNowTime() {
        String minuteStr = null;
        String dateStr = NewDateUtil.getCurrentDateStr();
        String string = NewDateUtil.getCurrentDateTimeStr();
        String minuStr = string.substring(14, 16);
        String hour = string.substring(11, 13);
        int minuInt = Integer.valueOf(minuStr);
        int a = minuInt / 15;
        int nowMinute = a * 15;
        minuteStr = String.valueOf(nowMinute);
        if (nowMinute == 0) {
            minuteStr = "00";
        }
        return dateStr + " " + hour + ":" + minuteStr + ":" + "00";
    }

    /**
     * @return java.lang.String
     * @throws
     * @author Crayon
     * @Description 返回时间格式 yyyy/M/d
     * @date 2019/11/8 4:42 下午
     * @params [date]
     */
    public static String getDate5Result(String date) {
        LocalDate localDate = LocalDate.parse(date, DATE_FORMATTER);
        return DATE_FORMATTER_TWO.format(localDate);
    }

    /**
     * @return java.lang.String
     * @throws
     * @author Liuxin
     * @Description 返回时间格式 yyyy/M/d HH:mm:ss
     * @date 2019/11/14 23:38 下午
     * @params [date]
     */
    public static String getDate6Result(String date) {
        System.out.println(date);
        String hourminuStr1 = date.substring(10, 19);
        //String dateStr2 = date.substring(0, 10).replaceAll("-","/");
        String dateStr2 = getDate5Result(date.substring(0, 10));
        return dateStr2 + hourminuStr1;
    }


    /**
     * @return java.lang.String
     * @throws
     * @author gongweimin
     * @Description 返回指定格式的时间段字符串 yyyy-MM-dd HH:mm-HH:mm（保证时间段不隔天） 例如2019/10/27 05:30-20:15
     * @date 2019/11/8 17:06
     * @params [date1, date2]
     */
    public static String getSpecifyDateTimeStr(String date1, String date2) {
        String hourminuStr1 = date1.substring(10, 16);
        String hourminuStr2 = date2.substring(11, 16);
        String dateStr2 = getDate5Result(date2.substring(0, 10));
        return dateStr2 + hourminuStr1 + "-" + hourminuStr2;
    }

    /**
     * @return java.lang.String
     * @throws
     * @author gongweimin
     * @Description 获得指定时间的n秒以前（以后）的时间
     * @date 2019/11/8 18:49
     * @params [date1, date2]
     */
    public static String getBeforeORAfterDateTimeStr(String date1, long n) {
        LocalDateTime localDatetime = LocalDateTime.parse(date1, DATETIME_FORMATTER);
        return localDatetime.plusSeconds(n).format(DATETIME_FORMATTER);
    }

    /***
     * @author gongweimin
     * @Description 得到当前时间，分钟数统一规整为00，05，10，15...........55
     * @date 2019/11/14 15:02
     * @params []
     * @exception
     * @return java.lang.String
     */
    public static String getNowTime5mins() {
        String minuteStr = null;
        String dateStr = NewDateUtil.getCurrentDateStr();
        String string = NewDateUtil.getCurrentDateTimeStr();
        String minuStr = string.substring(14, 16);
        String hour = string.substring(11, 13);
        int minuInt = Integer.valueOf(minuStr);
        int a = minuInt / 5;
        int nowMinute = a * 5;
        minuteStr = String.valueOf(nowMinute);
        if (nowMinute == 0) {
            minuteStr = "00";
        }
        return dateStr + " " + hour + ":" + minuteStr + ":" + "00";
    }

    public static boolean isInDate(String starttime, String endtime) throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date now = df.parse(df.format(new Date()));
        now = df.parse("05:54");
        Date begin = df.parse(starttime);
        Date end = df.parse(endtime);
        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(now);
        Calendar beginTime = Calendar.getInstance();
        beginTime.setTime(begin);
        Calendar endTime = Calendar.getInstance();
        endTime.setTime(end);
        return nowTime.before(endTime) && nowTime.after(beginTime);

    }

    /**
     *@author fengzhijia
     *@Description date 2019-12     return[2019-12-01,2020-01-01]
     *@date 2019/12/11 15:04
     *@params [date]
     *@exception
     *@return java.lang.String[]
     */
    public static String[] getTheMonthFirstDayAndTheNextMonthFirstDay(String date) {
        String[] splits = date.split("-");
        String startDate = date + "-01";
        String endDate = null;
        Integer endMonth = (Integer.parseInt(date.substring(5, 7)) + 1) % 12;
        if (endMonth == 0) {
            endDate = splits[0] + "-12-01";
        } else if (endMonth == 1) {
            endDate = new Integer(Integer.parseInt(splits[0]) + 1).toString()+"-01-01";
        } else if (endMonth >= 2 && endMonth <= 9) {
            endDate = splits[0] + "-0" + endMonth + "-01";
        } else {
            endDate = splits[0] + "-" + endMonth + "-01";
        }
        String[] array = new String[]{startDate, endDate};
        return array;
    }


    public static void main(String[] args) {

        String endtime = "23:30";
        String starttime = "05:30";
        try {
            System.out.println(isInDate(starttime, endtime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
