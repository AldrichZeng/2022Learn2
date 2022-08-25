package com.study;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.anyString;


class StudentTest {

    @Test
    public void testCalcScore1() {
        Student student = Mockito.mock(Student.class);
        Mockito.doReturn("in test1").when(student).calcScore();
        System.out.println(student.calcScore());
    }

    @Test
    public void testCalcScore2() {
        Student student = Mockito.mock(Student.class);
        // 如下调用并不会进入方法体
        Mockito.when(student.calcScore()).thenReturn("in test2");
        System.out.println(student.calcScore());
    }

    @Test
    public void testCalcScore3() {
        Student student = Mockito.spy(Student.class);
        // 尽管是spy对象，但是不会进入方法体
        Mockito.doReturn("in test3").when(student).calcScore();
        System.out.println(student.calcScore());
    }

    @Test
    public void testCalcScore4() {
        Student student = Mockito.spy(Student.class);
        // UnfinishedStubbingException
        Mockito.doReturn("in test4").when(student.calcScore());
        System.out.println(student.calcScore());
    }

    @Test
    public void testCalcScore5() {
        Student student = Mockito.spy(Student.class);
        // 进入到方法体
        Mockito.when(student.calcScore()).thenReturn("in test5");
        System.out.println(student.calcScore());
    }

    @Test
    public void testMethod1() {
        Student student = Mockito.spy(Student.class);
        Mockito.doReturn("in testMethod1").when(student).method("123", "456");
        // 未进入方法内部
        System.out.println(student.method("123", "456"));
        // 进入方法内部
        System.out.println(student.method("123", "789"));
    }

    @Test
    public void testMethod2() {
        Student student = Mockito.spy(Student.class);
        Mockito.doReturn("in testMethod2").when(student).method(anyString(), anyString());
        // 未进入方法内部
        System.out.println(student.method("123", "456"));
        // 未进入方法内部
        System.out.println(student.method("123", "789"));
    }

    @Test
    public void generateString() {
        String subStr = "value";
        String str = "";
        for (int i = 0; i < 26; i++) {
            if (i != 0) {
                str += "xxx" + subStr + String.valueOf(i);
            } else {
                str += subStr + String.valueOf(i);
            }
        }
        System.out.println(str);
        int x = str.length();
        System.out.println("str.length()="+x);
        int y = (x * 2 + 8 + 8 + 1) * (10/5);
        System.out.println("单行数据大小="+y);
    }

    @Test
    public void generateString2() {
        List<String> types = new ArrayList<>(Arrays.asList(new String[]{"string", "long", "date", "bool", "bytes"}));
        List<String> values = new ArrayList<>(Arrays.asList(new String[]{
                "\"value0xxxvalue1xxxvalue2xxxvalue3xxxvalue4xxxvalue5xxxvalue6xxxvalue7xxxvalue8xxxvalue9\"",
                "19890604", "\"1989-06-04 00:00:00\"", "true",
                "\"value0xxxvalue1xxxvalue2xxxvalue3xxxvalue4xxxvalue5xxxvalue6xxxvalue7xxxvalue8xxxvalue9\""}));
        for (int i = 0; i < 200; i++) {
            System.out.println("{");
            System.out.println("\"value\":" + values.get(i % 5) + ",");
            System.out.println("\"type\":\"" + types.get(i % 5) + "\"");
            if (i == 200 - 1) {
                System.out.println("}");
            } else {
                System.out.println("},");
            }
        }

    }

    @Test
    public void generateString3() {
        List<String> list = new ArrayList<>(Arrays.asList(new String[]{"STRING", "BIGINT", "DATE", "BOOLEAN", "STRING"}));
        for (int i = 0; i < 200; i++) {
            System.out.println("{");
            System.out.println("\"name\":\"column_" + String.valueOf(i)+"\",");
            System.out.println("\"type\":\"" + list.get(i % 5) + "\"");
            if (i == 200 - 1) {
                System.out.println("}");
            } else {
                System.out.println("},");
            }
        }
    }

    @Test
    public void StringBytes(){
        String a = "hello world";
        byte[] b= a.getBytes();
        for(int i = 0;i<b.length;i++){
//            System.out.println(b[i]);
            System.out.println(String.valueOf(Integer.toHexString(Integer.parseInt(String.valueOf(b[i])))));
        }

    }

    @Test
    public void testHex(){
        String a = "68 65 6c 6c 6f 20 77 6f 72 6c 64";
        String[] hexString = a.split(" ");
        for(int i=0;i<hexString.length;i++){
            System.out.println(hexString[i]);
            System.out.println(Integer.parseInt(hexString[i]));
        }
    }


}