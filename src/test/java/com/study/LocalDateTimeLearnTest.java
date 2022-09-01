package com.study;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author 匠承
 * @Date: 2022/8/31 14:49
 */
public class LocalDateTimeLearnTest {
    LocalDateTime localDateTime = LocalDateTime.parse("2022-08-31T15:36:12");

    @Test
    public void fun1() {
        // 什么是epoch？
        // 从1970-01-01T00:00:00Z开始的秒数，翻译为纪元秒。

        // 定义一个LocalDateTime
        System.out.println(localDateTime);

        // 将纪元秒转换为时间
        LocalDateTime.ofEpochSecond(100, 100, ZoneOffset.UTC);
    }

    @Test
    public void fun2() {
        LocalDateTime tmp = LocalDateTime.ofInstant(Instant.ofEpochMilli(-1000), ZoneId.of("UTC"));
        System.out.println(tmp);
    }

    @Test
    public void fun3() {
        long x = -123456L;
        System.out.println(x / 1000L);
    }

    @Test
    public void fun4() {
        long x = 123456789L;
        int y = (int) x % 1000000 * 1000;
        System.out.println(y);
    }

    @Test
    public void fun5() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("1900-01-01 00:00:00");
        System.out.println(date);
        System.out.println(date.getTime());//毫秒milliseconds
    }

    @Test
    public void fun6(){
        LocalDateTime ldt = LocalDateTime.ofEpochSecond(-62135596800L,124000000,ZoneOffset.UTC);
        System.out.println(ldt);
        System.out.println(ldt.toEpochSecond(ZoneOffset.of("+08:00:00")));
        System.out.println(ldt.toEpochSecond(ZoneOffset.UTC));
        System.out.println(ldt.getNano());
    }

    @Test
    public void fun7(){
        LocalDateTime ldt = LocalDateTime.ofEpochSecond(-0L,0,ZoneOffset.UTC);
        System.out.println(ldt);
        System.out.println(ldt.toEpochSecond(ZoneOffset.UTC));
        ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
        System.out.println(zdt);
        System.out.println(zdt.toEpochSecond());

    }

    @Test
    public void test() {
        Date now = new Date();
        System.out.println(now);//当前当地时间，是东八区时间

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(dateFormat.format(now));//GMT时间
    }

    @Test
    public void test2() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = dateFormat.parse("1970-01-01 00:00:00");// 自动转为东八区
        System.out.println(date);//东八区时间
        System.out.println(dateFormat.format(date));//GMT时间

        date = dateFormat.parse(dateFormat.format(date));
        System.out.println(date);//东八区

    }


    @Test
    public void test3() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse("1970-01-01 00:00:00");
        System.out.println(date);
        System.out.println(date.getTime());
        date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("1970-01-01 00:00:00");
        System.out.println(date);
        System.out.println(date.getTime());//Locale没有任何作用，依然是东八区时间

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        date = new Date();//当前当地时间
        System.out.println(date);//东八区
        System.out.println(dateFormat.format(new Date()));//东八区，说明Locale没有作用
    }
}
