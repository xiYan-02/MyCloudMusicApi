package com.example.mycloudmusicapi.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
public class TimeUtil {

    /**
     * 为指定时间添加指定天数后判断是否过期
     * @param outTime
     * @param i
     * @return true：过期，false：不过期
     */
    public static boolean plusDaysAfterNow(Timestamp outTime, int i) {
        LocalDateTime localDateTime = getLocalDateTime(outTime);
//        将原来的时间加指定的天数
        localDateTime = localDateTime.plusDays(i);

        return isAfterNow(localDateTime);

    }

    /**
     * 为指定时间添加指定分钟后判断是否过期
     * @param codeSentAt
     * @param i
     * @return true：过期，false：不过期
     */
    public static boolean plusMinutesAfterNow(Timestamp codeSentAt, int i) {
        LocalDateTime localDateTime = getLocalDateTime(codeSentAt);
//        将原来的时间加指定的天数
        localDateTime = localDateTime.plusMinutes(i);

        return isAfterNow(localDateTime);
    }

    /**
     * 判断当前时间是否在指定时间的前面,就是判断是否过期
     * @param oldLocalDateTime 传入的时间
     * @return
     */
    private static boolean isAfterNow(LocalDateTime oldLocalDateTime) {
        LocalDateTime nowLocalDateTime = LocalDateTime.now();
//        true:当前时间在指定时间的后面，过期
//        false：当前时间不在指定时间的后面，不过期
        boolean ress = nowLocalDateTime.isAfter(oldLocalDateTime);
        log.info("isAfterNow：{} {} {}",oldLocalDateTime,nowLocalDateTime,ress);
        return ress;
    }

    private static LocalDateTime getLocalDateTime(Timestamp time){
        long outTime = time.getTime();
        Instant instant = Instant.ofEpochMilli(outTime);
        return LocalDateTime.ofInstant(instant,ZoneId.systemDefault());
    }
}
