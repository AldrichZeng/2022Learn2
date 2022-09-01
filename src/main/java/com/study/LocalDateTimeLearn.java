package com.study;

import java.time.*;
import java.util.Date;

/**
 * @author 匠承
 * @Date: 2022/8/31 14:31
 */
public class LocalDateTimeLearn {
    public static void main(String[] args) {
        // 什么是epoch？
        // 从1970-01-01T00:00:00Z开始的秒数，翻译为纪元秒。

        // 定义一个LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse("2022-08-31T15:26:12");
        System.out.println("localDateTime = " + localDateTime);
        System.out.println("nano = " + localDateTime.getNano());

        // 获取epoch second
        long epochSecond = localDateTime.toEpochSecond(ZoneOffset.UTC);
        System.out.println("epochSecond = " + epochSecond);
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println("localDate = " + localDate);
        System.out.println("================");
        // 将纪元秒转换为时间
        localDateTime = LocalDateTime.ofEpochSecond(1561959123, 100, ZoneOffset.UTC);
        System.out.println("localDateTime = " + localDateTime);
        System.out.println("nano = " + localDateTime.getNano());
        System.out.println("================");
        // 精确到ms（毫秒）
        Date date = new Date(epochSecond * 1000);
        System.out.println("Date = " + date);
        System.out.println("Instant = " + date.toInstant());
        System.out.println("================");
        localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(epochSecond * 1000), ZoneId.of("UTC"));
        System.out.println("ofInstant = " + localDateTime);
        System.out.println("nano = " + localDateTime.getNano());

        localDateTime = LocalDateTime.ofEpochSecond(-1561959123, 100, ZoneOffset.UTC);
        System.out.println("localDateTime = " + localDateTime);

        Long value = 123456000L;
        LocalDateTime ldt = LocalDateTime.ofEpochSecond(value / 1000000, (int) (value % 1000000 * 1000), ZoneOffset.UTC);
    }


}
