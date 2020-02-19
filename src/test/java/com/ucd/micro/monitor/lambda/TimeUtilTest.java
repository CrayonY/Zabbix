package com.ucd.micro.monitor.lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: TimeUtil
 * @Description: 时间戳转换
 * @Author: Crayon
 * @CreateDate: 2019/11/8 11:39 上午
 * @Version 1.0
 * @Copyright: Copyright©2018-2019 BJCJ Inc. All rights reserved.
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TimeUtilTest {

    @Test
    public void timeTest(){
        /** 1.LocalDate转Date */

        LocalDate nowLocalDate = LocalDate.now();
        Date date = Date.from(nowLocalDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());

        /** 2.LocalDateTime转Date */
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date1 = Date.from(localDateTime.atZone(ZoneOffset.ofHours(8)).toInstant());


        /** 3.Date转LocalDateTime(LocalDate) */
        Date date2 = new Date();
        LocalDateTime localDateTime1 = date2.toInstant().atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        LocalDate localDate = date2.toInstant().atZone(ZoneOffset.ofHours(8)).toLocalDate();


        /** 4.LocalDate转时间戳 */
        LocalDate localDate1 = LocalDate.now();
        long longtimestamp = localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();

        /** 5.LocalDateTime转时间戳 */
        LocalDateTime localDateTime2 = LocalDateTime.now();
        long longtimestamp1 = localDateTime2.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();



        /** 6.时间戳转LocalDateTime(LocalDate) */
        long timestamp = System.currentTimeMillis();
        LocalDate localDate3 = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        LocalDateTime localDateTime3 = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }


    /**
     * 判断时间区间
     */
    @Test
    public void isEffectiveDate(){
        try {
            String format = "HH:mm:ss";
            Date nowTime = new SimpleDateFormat(format).parse("09:27:00");
            Date startTime = null;
            startTime = new SimpleDateFormat(format).parse("23:27:00");
            Date endTime = new SimpleDateFormat(format).parse("06:27:59");
          /*  if (nowTime.getTime() == startTime.getTime()
                    || nowTime.getTime() == endTime.getTime()) {
                return true;
            }*/

            Calendar date = Calendar.getInstance();
            date.setTime(nowTime);

            Calendar begin = Calendar.getInstance();
            begin.setTime(startTime);

            Calendar end = Calendar.getInstance();
            end.setTime(endTime);



            if (date.after(begin) && date.before(end)) {
                System.out.printf("true");
            } else {
                System.out.printf("false");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean notBefore = LocalTime.parse("05:27:00:000").isBefore(LocalTime.parse("06:27:59:000"));
        boolean isAfter = LocalTime.parse("05:27:00:000").isAfter(LocalTime.parse("23:27:00:000"));

    }

}
