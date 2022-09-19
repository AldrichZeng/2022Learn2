package com.study.MockTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ATest {

    @InjectMocks
    A a;
    @InjectMocks
    B b;
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void test1(){
        System.out.println("调用a的fun");
        a.fun();
        System.out.println("调用b的fun");
        b.fun();
    }
    @Test
    public void test2(){
        System.out.println("调用A的method");
        a.method();
        System.out.println("调用B的method");
        b.method();
    }

    /**
     * 如下调用方式并不会报错
     */
    @Test
    public void test3(){
        A aa = Mockito.mock(B.class);
        aa.fun();
        aa.method();

        A aaa = new B();
        aaa.fun();
        aaa.method();
    }
}
