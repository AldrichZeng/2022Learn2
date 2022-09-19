package com.study.MockTest;

public class B extends A{
    @Override
    public String fun(){
        System.out.println("In B, 子类");
        return "B的fun";
    }

    @Override
    protected String protectedMethod2(){
        System.out.println("B 重写的protectedMethod2");
        return "B 重写的protected method";
    }
}
