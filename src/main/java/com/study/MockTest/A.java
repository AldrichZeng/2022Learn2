package com.study.MockTest;

public class A {

    /**
     * 该方法会被子类重写
     * @return
     */
    public String fun(){
        System.out.println("In A, 父类");
        return "A的fun";
    }

    /**
     * 该方法仅父类用，子类不重写
     */
    public String method(){
        System.out.println("In A, 父类方法，子类不重写");
        return "A的method";
    }

    protected String protectedMethod(){
        System.out.println("In A, propected method");
        return "A protected";
    }

    protected String protectedMethod2(){
        System.out.println("In A, propected method, 但会被子类重写");
        return "A 会被子类重写的protected method";
    }
}
