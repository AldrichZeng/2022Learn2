package com.study;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        System.out.println(student.method("123","456"));
        // 进入方法内部
        System.out.println(student.method("123","789"));
    }

    @Test
    public void testMethod2() {
        Student student = Mockito.spy(Student.class);
        Mockito.doReturn("in testMethod2").when(student).method(anyString(), anyString());
        // 未进入方法内部
        System.out.println(student.method("123","456"));
        // 未进入方法内部
        System.out.println(student.method("123","789"));
    }


}